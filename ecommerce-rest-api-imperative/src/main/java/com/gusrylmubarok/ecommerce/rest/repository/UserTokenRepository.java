package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.UserTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends CrudRepository<UserTokenEntity, UUID> {
    Optional<UserTokenEntity> findByRefreshToken(String refreshToken);
    Optional<UserTokenEntity> deleteByUserId(UUID userId);
}
