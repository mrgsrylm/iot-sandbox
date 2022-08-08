package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
  Mono<OrderEntity> addOrder(@Valid Mono<NewOrder> newOrder);
  Mono<OrderEntity> updateMapping(@Valid OrderEntity orderEntity);
  Flux<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  Mono<OrderEntity> getByOrderId(String id);
}
