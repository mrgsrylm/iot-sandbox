package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import com.gusrylmubarok.ecommerce.rest.model.Item;
import javax.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CartService {
  Flux<Item> addCartItemsByCustomerId(CartEntity cartEntity, @Valid Mono<Item> item);
  Flux<Item> addOrReplaceItemsByCustomerId(CartEntity cartEntity, @Valid Mono<Item> newItem);
  Mono<Void> deleteCart(String customerId, String cartId);
  Mono<Void> deleteItemFromCart(CartEntity cartEntity, String itemId);
  Mono<CartEntity> getCartByCustomerId(String customerId);
}
