package com.gusrylmubarok.ecommerce.rest.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.gusrylmubarok.ecommerce.rest.CustomerApi;
import com.gusrylmubarok.ecommerce.rest.exception.ResourceNotFoundException;
import com.gusrylmubarok.ecommerce.rest.hateoas.AddressRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.hateoas.CardRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.hateoas.UserRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.Address;
import com.gusrylmubarok.ecommerce.rest.model.Card;
import com.gusrylmubarok.ecommerce.rest.model.User;
import com.gusrylmubarok.ecommerce.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController implements CustomerApi {
  private final UserRepresentationModelAssembler assembler;
  private final AddressRepresentationModelAssembler addrAssembler;
  private final CardRepresentationModelAssembler cardAssembler;
  private UserService service;

  public CustomerController(UserService service, UserRepresentationModelAssembler assembler,
      AddressRepresentationModelAssembler addrAssembler,
      CardRepresentationModelAssembler cardAssembler) {
    this.service = service;
    this.assembler = assembler;
    this.addrAssembler = addrAssembler;
    this.cardAssembler = cardAssembler;
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteCustomerById(String id, ServerWebExchange exchange) {
    return service.getCustomerById(id)
        .flatMap(c -> service.deleteCustomerById(c.getId())
            .then(Mono.just(status(HttpStatus.ACCEPTED).<Void>build())))
        .switchIfEmpty(Mono.just(notFound().build()));
  }

  @Override
  public Mono<ResponseEntity<Flux<Address>>> getAddressesByCustomerId(String id,
      ServerWebExchange exchange) {

    return Mono.just(ok(service.getAddressesByCustomerId(id)
        .map(c -> addrAssembler.entityToModel(c, exchange))
        .switchIfEmpty(
            Mono.error(new ResourceNotFoundException("No address found for given customer")))));
  }

  @Override
  public Mono<ResponseEntity<Flux<User>>> getAllCustomers(ServerWebExchange exchange) {
    return Mono.just(ok(assembler.toListModel(service.getAllCustomers(), exchange)));
  }

  @Override
  public Mono<ResponseEntity<Card>> getCardByCustomerId(String id, ServerWebExchange exchange) {
    return service.getCardByCustomerId(id).map(c -> cardAssembler.entityToModel(c, exchange))
        .map(ResponseEntity::ok)
        .defaultIfEmpty(notFound().build());
  }

  @Override
  public Mono<ResponseEntity<User>> getCustomerById(String id, ServerWebExchange exchange) {
    return service.getCustomerById(id).map(c -> assembler.entityToModel(c, exchange))
        .map(ResponseEntity::ok)
        .defaultIfEmpty(notFound().build());
  }
}
