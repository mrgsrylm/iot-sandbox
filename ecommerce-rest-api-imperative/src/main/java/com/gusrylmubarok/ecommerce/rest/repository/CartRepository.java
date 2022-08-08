package com.gusrylmubarok.ecommerce.rest.repository;

import java.util.Optional;
import java.util.UUID;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends CrudRepository<CartEntity, UUID> {
  @Query("select c from CartEntity c join c.user u where u.id = :customerId")
  public Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
