package com.gusrylmubarok.ecommerce.rest.entity;

import java.util.UUID;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ecomm.user_address")
public class UserAddressEntity {
  @Column("user_id")
  private UUID userId;

  @Column("address_id")
  private UUID addressID;

  public UUID getUserId() {
    return userId;
  }

  public UserAddressEntity setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public UUID getAddressID() {
    return addressID;
  }

  public UserAddressEntity setAddressID(UUID addressID) {
    this.addressID = addressID;
    return this;
  }
}
