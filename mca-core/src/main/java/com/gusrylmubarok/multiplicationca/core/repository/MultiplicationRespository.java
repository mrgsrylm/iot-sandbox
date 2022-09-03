package com.gusrylmubarok.multiplicationca.core.repository;

import com.gusrylmubarok.multiplicationca.core.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve multiplications
 */
public interface MultiplicationRespository extends CrudRepository<Multiplication, Long> {

}
