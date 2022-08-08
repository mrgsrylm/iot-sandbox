package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.AuthorizationEntity;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AuthorizationRepository extends ReactiveCrudRepository<AuthorizationEntity, UUID> {
}

