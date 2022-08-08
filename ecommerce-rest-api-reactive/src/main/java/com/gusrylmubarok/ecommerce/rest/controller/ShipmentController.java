package com.gusrylmubarok.ecommerce.rest.controller;

import com.gusrylmubarok.ecommerce.rest.ShipmentApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.ShipmentRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.Shipment;
import com.gusrylmubarok.ecommerce.rest.service.ShipmentService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ShipmentController implements ShipmentApi {
  private final ShipmentRepresentationModelAssembler assembler;

  private ShipmentService service;

  public ShipmentController(ShipmentService service,
      ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public Mono<ResponseEntity<Flux<Shipment>>> getShipmentByOrderId(@NotNull @Valid String id,
      ServerWebExchange exchange) {
    return Mono
        .just(ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id), exchange)));
  }
}
