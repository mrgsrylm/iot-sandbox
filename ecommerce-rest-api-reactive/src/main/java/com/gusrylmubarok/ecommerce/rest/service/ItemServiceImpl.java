package com.gusrylmubarok.ecommerce.rest.service;

import static java.util.stream.Collectors.toList;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import com.gusrylmubarok.ecommerce.rest.model.Item;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ItemServiceImpl implements ItemService {

  @Override
  public Mono<ItemEntity> toEntity(Mono<Item> model) {
    return model.map(m ->
        new ItemEntity()
            .setPrice(m.getUnitPrice())
            .setQuantity(m.getQuantity())
    );
  }

  @Override
  public Mono<List<Item>> fluxTolList(Flux<ItemEntity> items) {
    if (Objects.isNull(items)) {
      return Mono.just(Collections.emptyList());
    }
    return items.map(e -> toModel(e)).collectList();
  }

  @Override
  public Flux<Item> toItemFlux(Mono<CartEntity> cart) {
    if (Objects.isNull(cart)) {
      return Flux.empty();
    }
    return cart.flatMapMany(c -> toModelFlux(c.getItems()));
  }

  @Override
  public ItemEntity toEntity(Item m) {
    ItemEntity e = new ItemEntity();
    e.setProductId(UUID.fromString(m.getId()))
        .setPrice(m.getUnitPrice())
        .setQuantity(m.getQuantity());
    return e;
  }

  @Override
  public List<ItemEntity> toEntityList(List<Item> items) {
    if (Objects.isNull(items)) {
      return Collections.emptyList();
    }
    return items.stream().map(m -> toEntity(m)).collect(toList());
  }

  @Override
  public Item toModel(ItemEntity e) {
    Item m = new Item();
    m.id(e.getProductId().toString())
        .unitPrice(e.getPrice()).quantity(e.getQuantity());
    return m;
  }

  @Override
  public List<Item> toModelList(List<ItemEntity> items) {
    if (Objects.isNull(items)) {
      return Collections.emptyList();
    }
    return items.stream().map(e -> toModel(e)).collect(toList());
  }

  @Override
  public Flux<Item> toModelFlux(List<ItemEntity> items) {
    if (Objects.isNull(items)) {
      return Flux.empty();
    }
    return Flux.fromIterable(items.stream().map(e -> toModel(e)).collect(toList()));
  }
}
