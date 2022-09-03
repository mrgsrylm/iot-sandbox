package com.gusrylmubarok.multiplicationca.core.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAlias(final String alias);
    List<User> findAllByIdIn(final List<Long> ids);
}
