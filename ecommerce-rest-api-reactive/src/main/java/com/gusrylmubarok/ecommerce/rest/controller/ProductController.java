package com.gusrylmubarok.ecommerce.rest.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.gusrylmubarok.ecommerce.rest.ProductApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.ProductRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.Product;
import com.gusrylmubarok.ecommerce.rest.service.ProductService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController implements ProductApi {
  private final ProductRepresentationModelAssembler assembler;

  private ProductService service;

  public ProductController(ProductService service, ProductRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public Mono<ResponseEntity<Product>> getProduct(String id, ServerWebExchange exchange) {
    return service.getProduct(id).map(p -> assembler.entityToModel(p, exchange))
        .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Flux<Product>>> queryProducts(@Valid String tag, @Valid String name,
      @Valid Integer page, @Valid Integer size, ServerWebExchange exchange) {
    return Mono.just(ok(assembler.toListModel(service.getAllProducts(), exchange)));
  }
}
