package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.ShipmentEntity;
import javax.validation.constraints.Min;
import reactor.core.publisher.Flux;

public interface ShipmentService {
  Flux<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
