package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.ShipmentEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ShipmentRepository extends ReactiveCrudRepository<ShipmentEntity, UUID> {
  @Query("SELECT s.* FROM ecomm.order o, ecomm.shipment s where o.shipment_id=s.id and o.id = :id")
  Flux<ShipmentEntity> getShipmentByOrderId(String id);
}

