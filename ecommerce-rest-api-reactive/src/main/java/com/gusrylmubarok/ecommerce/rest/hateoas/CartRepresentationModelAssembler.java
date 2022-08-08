package com.gusrylmubarok.ecommerce.rest.hateoas;

import static java.util.stream.Collectors.toList;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import com.gusrylmubarok.ecommerce.rest.model.Cart;
import com.gusrylmubarok.ecommerce.rest.model.Item;
import com.gusrylmubarok.ecommerce.rest.service.ItemService;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.util.Strings;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CartRepresentationModelAssembler implements
    ReactiveRepresentationModelAssembler<CartEntity, Cart>, HateoasSupport {

  private static String serverUri = null;
  private ItemService itemService;

  public CartRepresentationModelAssembler(ItemService itemService) {
    this.itemService = itemService;
  }

  private String getServerUri(@Nullable ServerWebExchange exchange) {
    if (Strings.isBlank(serverUri)) {
      serverUri = getUriComponentBuilder(exchange).toUriString();
    }
    return serverUri;
  }

  public Mono<Cart> toModel(CartEntity entity, ServerWebExchange exchange) {
    return Mono.just(entityToModel(entity, exchange));
  }

  public Cart entityToModel(CartEntity entity, ServerWebExchange exchange) {
    Cart resource = new Cart();
    if(Objects.isNull(entity)) {
      return resource;
    }
    resource.id(entity.getId().toString()).customerId(entity.getUser().getId().toString()).items(itemfromEntities(entity.getItems()));
    String serverUri = getServerUri(exchange);
    resource
        .add(Link.of(String.format("%s/api/v1/carts/%s", serverUri, entity.getId())).withSelfRel());
    return resource;
  }

  public List<Item> itemfromEntities(List<ItemEntity> items) {
    return items.stream().map(
        i -> new Item().id(i.getProductId().toString()).unitPrice(i.getPrice())
            .quantity(i.getQuantity())).collect(toList());
  }

  public Cart monoToModel(Mono<CartEntity> mEntity, ServerWebExchange exchange) {
    return getModel(mEntity.map(e -> entityToModel(e, exchange)));
  }

  public Cart getModel(Mono<Cart> m) {
    AtomicReference<Cart> model = new AtomicReference<>();
    m.cache().subscribe(i -> model.set(i));
    return model.get();
  }

  public Flux<Cart> toListModel(Flux<CartEntity> entities, ServerWebExchange exchange) {
    if (Objects.isNull(entities)) {
      return Flux.empty();
    }
    return Flux.from(entities.map(e -> entityToModel(e, exchange)));
  }
}
