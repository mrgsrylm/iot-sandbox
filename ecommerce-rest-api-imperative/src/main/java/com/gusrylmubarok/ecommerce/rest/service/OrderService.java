package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderService {
  public Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
  public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  public Optional<OrderEntity> getByOrderId(String id);
}
