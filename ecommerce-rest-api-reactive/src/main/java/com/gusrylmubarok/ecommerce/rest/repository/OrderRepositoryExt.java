package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;
import reactor.core.publisher.Mono;

public interface OrderRepositoryExt {
  Mono<OrderEntity> insert(Mono<NewOrder> m);
  Mono<OrderEntity> updateMapping(OrderEntity orderEntity);
}

