package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AddressEntity;
import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import java.util.Optional;


public interface UserService {
  public void deleteCustomerById(String id);
  public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  public Iterable<UserEntity> getAllCustomers();
  public Optional<CardEntity> getCardByCustomerId(String id);
  public Optional<UserEntity> getCustomerById(String id);
}
