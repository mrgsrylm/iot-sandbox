package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
  Optional<OrderEntity> insert(NewOrder m);
}

