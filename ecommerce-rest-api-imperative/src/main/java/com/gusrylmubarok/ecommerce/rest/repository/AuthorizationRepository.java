package com.gusrylmubarok.ecommerce.rest.repository;

import java.util.UUID;

import com.gusrylmubarok.ecommerce.rest.entity.AuthorizationEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizationRepository extends CrudRepository<AuthorizationEntity, UUID> {
}

