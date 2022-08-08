package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AddressEntity;
import com.gusrylmubarok.ecommerce.rest.model.AddAddressReq;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressService {
  Mono<AddressEntity> createAddress(Mono<AddAddressReq> addAddressReq);
  Mono<Void> deleteAddressesById(String id);
  Mono<Void> deleteAddressesById(UUID id);
  Mono<AddressEntity> getAddressesById(String id);
  Flux<AddressEntity> getAllAddresses();
}
