package com.gusrylmubarok.ecommerce.rest.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.gusrylmubarok.ecommerce.rest.CardApi;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import com.gusrylmubarok.ecommerce.rest.exception.CardAlreadyExistsException;
import com.gusrylmubarok.ecommerce.rest.exception.CustomerNotFoundException;
import com.gusrylmubarok.ecommerce.rest.hateoas.CardRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.AddCardReq;
import com.gusrylmubarok.ecommerce.rest.model.Card;
import com.gusrylmubarok.ecommerce.rest.service.CardService;
import com.gusrylmubarok.ecommerce.rest.service.UserService;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CardController implements CardApi {
  private final CardRepresentationModelAssembler assembler;
  private CardService service;
  private UserService userService;

  public CardController(CardService service, CardRepresentationModelAssembler assembler,
      UserService userService) {
    this.service = service;
    this.assembler = assembler;
    this.userService = userService;
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteCardById(String id, ServerWebExchange exchange) {
    return service.getCardById(id)
        .flatMap(c -> service.deleteCardById(c.getId())
            .then(Mono.just(status(HttpStatus.ACCEPTED).<Void>build())))
        .switchIfEmpty(Mono.just(notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Card>> registerCard(@Valid Mono<AddCardReq> addCardReq,
      ServerWebExchange exchange) {
    Mono<AddCardReq> mono = addCardReq.cache();
    return validate(mono)
        .flatMap(d -> userService.getCardByCustomerId(d.getId().toString())
            .flatMap(card -> {
              if (Objects.isNull(card.getId())) {
                return service.registerCard(mono)
                    .map(ce -> status(HttpStatus.CREATED)
                        .body(assembler.entityToModel(ce, exchange)));
              } else {
                return Mono.error(
                    () -> new CardAlreadyExistsException(" for user with ID - " + d.getId()));
              }
            })
            .switchIfEmpty(service.registerCard(mono)
                .map(ce -> status(HttpStatus.CREATED).body(assembler.entityToModel(ce, exchange))))
        );
  }

  private Mono<UserEntity> validate(Mono<AddCardReq> addCardReq) {
    return addCardReq.flatMap(req -> userService.getCustomerById(req.getUserId()))
        .switchIfEmpty(Mono.error(new CustomerNotFoundException(". Check the payload.")));
  }

  @Override
  public Mono<ResponseEntity<Flux<Card>>> getAllCards(ServerWebExchange exchange) {
    return Mono.just(ok(assembler.toListModel(service.getAllCards(), exchange)));
  }

  @Override
  public Mono<ResponseEntity<Card>> getCardById(String id, ServerWebExchange exchange) {
    return service.getCardById(id).map(c -> assembler.entityToModel(c, exchange))
        .map(ResponseEntity::ok).defaultIfEmpty(notFound().build());
  }
}
