package com.gusrylmubarok.ecommerce.rest.controller;

import com.gusrylmubarok.ecommerce.rest.ShipmentApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.ShipmentRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.Shipment;
import com.gusrylmubarok.ecommerce.rest.service.ShipmentService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController implements ShipmentApi {

  private ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<Shipment>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
