package com.gusrylmubarok.multiplicationca.core.service;

import com.gusrylmubarok.multiplicationca.core.domain.Multiplication;

public interface MultiplicationService {
    /**
     *  Create a Multiplication object with two randomly-generated factors
     *  @return a multiplication
     */
    Multiplication createRandomMultiplication();
}
