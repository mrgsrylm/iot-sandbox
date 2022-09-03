package com.gusrylmubarok.multiplicationca.core.repository;

import com.gusrylmubarok.multiplicationca.core.domain.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface allow us to store and retrieve attempts
 */
public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt, Long> {
    /**
     * @return the latest 5 attempts for given user, identified by thier alias
     */
    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
