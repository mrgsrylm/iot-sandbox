package com.gusrylmubarok.multiplicationca.core.challenge;

import com.gusrylmubarok.multiplicationca.core.clients.GamificationServiceClient;
import com.gusrylmubarok.multiplicationca.core.user.User;
import com.gusrylmubarok.multiplicationca.core.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTests {
    private ChallengeService challengeService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private ChallengeAttemptRepository attemptRepository;
    @Mock
    private GamificationServiceClient gameClient;

    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl(userRepository, attemptRepository, gameClient);
        // Keep in mind that we needed to move the
        // given(attemptRepository)... to the test cases
        // that use it to prevent the unused stubs errors.
    }

    @Test
    public void checkCorrectAttemptTest() {
        // given
        given(attemptRepository.save(any())).will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "budi_do", 3000);
        // when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isTrue();
        verify(userRepository).save(new User("budi_do"));
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void checkWrongAttemptTest() {
        // given
        given(attemptRepository.save(any())).will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "budi_do", 5000);
        // when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isFalse();
        verify(userRepository).save(new User("budi_do"));
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void checkExistingUserTest() {
        // given
        given(attemptRepository.save(any())).will(returnsFirstArg());
        User existingUser = new User(1L, "budi_do");
        given(userRepository.findByAlias("budi_do"))
                .willReturn(Optional.of(existingUser));
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "budi_do", 5000);
        // when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isFalse();
        then(resultAttempt.getUser()).isEqualTo(existingUser);
        verify(userRepository, never()).save(any());
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void retrieveStatsTest() {
        // given
        User user = new User("budi_do");
        ChallengeAttempt attempt1 = new ChallengeAttempt(1L, user, 50, 60, 3010, false);
        ChallengeAttempt attempt2 = new ChallengeAttempt(2L, user, 50, 60, 3051, false);
        List<ChallengeAttempt> lastAttempts = List.of(attempt1, attempt2);
        given(attemptRepository.findTop10ByUserAliasOrderByIdDesc("budi_do"))
                .willReturn(lastAttempts);
        // when
        List<ChallengeAttempt> latestAttemptsResult = challengeService
                .getStatsForUser("budi_do");
        // then
        then(latestAttemptsResult).isEqualTo(lastAttempts);
    }
}
