package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AddressEntity;
import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import com.gusrylmubarok.ecommerce.rest.repository.UserRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public Mono<Void> deleteCustomerById(String id) {
    return deleteCustomerById(UUID.fromString(id));
  }

  @Override
  public Mono<Void> deleteCustomerById(UUID id) {
    return repository.deleteById(id).then();
  }

  @Override
  public Flux<AddressEntity> getAddressesByCustomerId(String id) {
    return repository.getAddressesByCustomerId(id);
  }

  @Override
  public Flux<UserEntity> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public Mono<CardEntity> getCardByCustomerId(String id) {
    return repository.findCardByCustomerId(id);
  }

  @Override
  public Mono<UserEntity> getCustomerById(String id) {
    return repository.findById(UUID.fromString(id));
  }
}
