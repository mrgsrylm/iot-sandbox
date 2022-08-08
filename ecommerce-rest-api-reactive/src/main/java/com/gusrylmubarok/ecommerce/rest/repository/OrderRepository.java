package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<OrderEntity, UUID>, OrderRepositoryExt {
  @Query("select o.* from ecomm.orders o join ecomm.user u on o.customer_id = u.id where u.id = :custId")
  Flux<OrderEntity> findByCustomerId(String custId);
}
