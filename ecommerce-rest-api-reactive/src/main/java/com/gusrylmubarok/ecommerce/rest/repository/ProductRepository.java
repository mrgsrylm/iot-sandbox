package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.ProductEntity;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, UUID> {

}
