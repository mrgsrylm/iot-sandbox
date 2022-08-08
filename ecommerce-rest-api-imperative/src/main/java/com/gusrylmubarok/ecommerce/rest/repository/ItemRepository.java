package com.gusrylmubarok.ecommerce.rest.repository;

import java.util.List;
import java.util.UUID;

import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, UUID> {
  @Query(value = "select i.* from ecomm.cart c, ecomm.item i, ecomm.user u, ecomm.cart_item ci where u.id = :customerId and c.user_id=u.id and c.id=ci.cart_id and i.id=ci.item_id", nativeQuery=true)
  Iterable<ItemEntity> findByCustomerId(String customerId);

  @Modifying
  @Query(value = "delete from ecomm.cart_item where item_id in (:ids) and cart_id = :cartId", nativeQuery = true)
  void deleteCartItemJoinById(List<UUID> ids, UUID cartId);
}

