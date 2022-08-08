package com.gusrylmubarok.ecommerce.rest.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ecomm.item")
public class ItemEntity {

  @Id
  @Column("id")
  private UUID id;

  @Column("product_id")
  private UUID productId;

  @Column("unit_price")
  private BigDecimal price;

  @Column("quantity")
  private int quantity;

  public UUID getId() {
    return id;
  }

  public ItemEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public ItemEntity setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public int getQuantity() {
    return quantity;
  }

  public ItemEntity setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public UUID getProductId() {
    return productId;
  }

  public ItemEntity setProductId(UUID productId) {
    this.productId = productId;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemEntity that = (ItemEntity) o;
    return quantity == that.quantity && productId.equals(that.productId)
        && Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, price, quantity);
  }
}
