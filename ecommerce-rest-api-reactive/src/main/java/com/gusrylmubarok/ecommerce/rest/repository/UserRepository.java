package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.AddressEntity;
import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, UUID> {
  @Query("SELECT a.* FROM ecomm.user u, ecomm.address a, ecomm.user_address ua where u.id=ua.user_id and a.id=ua.address_id and u.id = :id")
  Flux<AddressEntity> getAddressesByCustomerId(String id);
  @Query("SELECT c.* FROM ecomm.user u, ecomm.card c where u.id=c.user_id and u.id = :id")
  Mono<CardEntity> findCardByCustomerId(String id);
}

