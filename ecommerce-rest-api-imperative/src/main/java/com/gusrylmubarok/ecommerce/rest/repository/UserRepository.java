package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
    @Query(value = "select count(u.*) from ecomm.user u where u.username = :username or u.email = :email", nativeQuery = true)
    Integer findByUsernameOrEmail(String username, String email);
}

