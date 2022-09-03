package com.gusrylmubarok.multiplicationca.core.repository;

import com.gusrylmubarok.multiplicationca.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This interface allows us to save and retrieve Users
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAlias(final String alias);
}
