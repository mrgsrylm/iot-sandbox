package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import com.gusrylmubarok.ecommerce.rest.model.Item;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
  Mono<ItemEntity> toEntity(Mono<Item> e);
  Mono<List<Item>> fluxTolList(Flux<ItemEntity> items);
  Flux<Item> toItemFlux(Mono<CartEntity> items);
  ItemEntity toEntity(Item m);
  List<ItemEntity> toEntityList(List<Item> items);
  Item toModel(ItemEntity e);
  List<Item> toModelList(List<ItemEntity> items);
  Flux<Item> toModelFlux(List<ItemEntity> items);
}
