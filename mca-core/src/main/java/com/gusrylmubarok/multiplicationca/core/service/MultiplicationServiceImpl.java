package com.gusrylmubarok.multiplicationca.core.service;

import com.gusrylmubarok.multiplicationca.core.domain.Multiplication;
import com.gusrylmubarok.multiplicationca.core.domain.MultiplicationResultAttempt;
import com.gusrylmubarok.multiplicationca.core.domain.User;
import com.gusrylmubarok.multiplicationca.core.repository.MultiplicationResultAttemptRepository;
import com.gusrylmubarok.multiplicationca.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    private RandomGeneratorService randomGeneratorService;
    private MultiplicationResultAttemptRepository attemptRepository;
    private UserRepository userRepository;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService,
                                     MultiplicationResultAttemptRepository attemptRepository,
                                     UserRepository userRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
        // check if the use already exists for that alias
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

        // Avoid 'hack attempts
        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!");

        // check if the attempt is correct
        boolean isCorrect = attempt.getResultAttempt() == attempt.getMultiplication().getFactorA() * attempt.getMultiplication().getFactorB();

        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
                attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

        // Stores the attempt
        attemptRepository.save(checkedAttempt);

        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }
}
