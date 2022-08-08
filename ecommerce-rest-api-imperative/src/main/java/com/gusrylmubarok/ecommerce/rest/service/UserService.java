package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AddressEntity;
import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;
import com.gusrylmubarok.ecommerce.rest.model.RefreshToken;
import com.gusrylmubarok.ecommerce.rest.model.SignedInUser;
import com.gusrylmubarok.ecommerce.rest.model.User;

import java.util.Optional;


public interface UserService {
  public void deleteCustomerById(String id);
  public Optional<Iterable<AddressEntity>> getAddressesByCustomerId(String id);
  public Iterable<UserEntity> getAllCustomers();
  public Optional<CardEntity> getCardByCustomerId(String id);
  public Optional<UserEntity> getCustomerById(String id);
  Optional<SignedInUser> createUser(User user);
  UserEntity findUserByUsername(String username);
  SignedInUser getSignedInUser(UserEntity userEntity);
  Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);
  void removeRefreshToken(RefreshToken refreshToken);
}
