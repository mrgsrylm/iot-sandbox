package com.gusrylmubarok.ecommerce.rest.entity;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ecomm.tag")
public class TagEntity {

  @Id
  @Column("id")
  private UUID id;

  @NotNull(message = "Product name is required.")
  @Column("name")
  private String name;

  public UUID getId() {
    return id;
  }

  public TagEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public TagEntity setName(String name) {
    this.name = name;
    return this;
  }
}
