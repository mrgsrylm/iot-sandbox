package com.gusrylmubarok.ecommerce.rest.hateoas;

import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.model.Card;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CardRepresentationModelAssembler implements
    ReactiveRepresentationModelAssembler<CardEntity, Card>, HateoasSupport {

  private static String serverUri = null;

  private String getServerUri(@Nullable ServerWebExchange exchange) {
    if (Strings.isBlank(serverUri)) {
      serverUri = getUriComponentBuilder(exchange).toUriString();
    }
    return serverUri;
  }

  @Override
  public Mono<Card> toModel(CardEntity entity, ServerWebExchange exchange) {
    return Mono.just(entityToModel(entity, exchange));
  }

  public Card entityToModel(CardEntity entity, ServerWebExchange exchange) {
    Card resource = new Card();
    if(Objects.isNull(entity)) {
      return resource;
    }
    BeanUtils.copyProperties(entity, resource);
    resource.setId(Objects.nonNull(entity.getId())? entity.getId().toString() : "");
    resource.setCardNumber(entity.getNumber());
    String serverUri = getServerUri(exchange);
    resource.add(Link.of(String.format("%s/api/v1/cards", serverUri)).withRel("cards"));
    resource.add(
        Link.of(String.format("%s/api/v1/cards/%s", serverUri, entity.getId())).withRel("self"));
    return resource;
  }

  public Card getModel(Mono<Card> m, ServerWebExchange exchange) {
    AtomicReference<Card> model = new AtomicReference<>();
    m.cache().subscribe(i -> model.set(i));
    return model.get();
  }

  public Flux<Card> toListModel(Flux<CardEntity> entities, ServerWebExchange exchange) {
    if (Objects.isNull(entities)) {
      return Flux.empty();
    }
    return Flux.from(entities.map(e -> entityToModel(e, exchange)));
  }
}
