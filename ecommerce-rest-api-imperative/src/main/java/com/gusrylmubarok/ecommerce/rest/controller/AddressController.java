package com.gusrylmubarok.ecommerce.rest.controller;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.gusrylmubarok.ecommerce.rest.AddressApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.AddressRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.AddAddressReq;
import com.gusrylmubarok.ecommerce.rest.model.Address;
import com.gusrylmubarok.ecommerce.rest.service.AddressService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController implements AddressApi {

  private AddressService service;
  private final AddressRepresentationModelAssembler assembler;

  public AddressController(AddressService addressService, AddressRepresentationModelAssembler assembler) {
    this.service = addressService;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Address> createAddress(@Valid AddAddressReq addAddressReq) {
    return status(HttpStatus.CREATED).body(service.createAddress(addAddressReq)
        .map(assembler::toModel).get());
  }

  @Override
  public ResponseEntity<Void> deleteAddressesById(String id) {
    service.deleteAddressesById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<Address> getAddressesById(String id) {
    return service.getAddressesById(id).map(assembler::toModel)
        .map(ResponseEntity::ok).orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<Address>> getAllAddresses() {
    return ok(assembler.toListModel(service.getAllAddresses()));
  }
}
