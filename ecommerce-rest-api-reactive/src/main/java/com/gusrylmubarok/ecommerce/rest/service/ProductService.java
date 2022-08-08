package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.ProductEntity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
public interface ProductService {
  @NotNull Flux<ProductEntity> getAllProducts();
  Mono<ProductEntity> getProduct(@Min(value = 1L, message = "Invalid product ID.") String id);
}