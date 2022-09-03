package com.gusrylmubarok.mca.gamification.game;

import com.gusrylmubarok.mca.gamification.challenge.ChallengeSolvedDTO;
import com.gusrylmubarok.mca.gamification.game.badgeprocessors.BadgeProcessor;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeCard;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeType;
import com.gusrylmubarok.mca.gamification.game.domain.ScoreCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final ScoreRepository scoreRepository;
    private final BadgeRepository badgeRepository;
    // Spring injects all the @Component beans in this list
    private final List<BadgeProcessor> badgeProcessors;

    @Override
    public GameResult newAttemptForUser(final ChallengeSolvedDTO challenge) {
        // We give points only if it's correct
        if (challenge.isCorrent()) {
            ScoreCard scoreCard = new ScoreCard(challenge.getUserId(), challenge.getAttemptId());
            scoreRepository.save(scoreCard);
            log.info("User {} scored {} points for attempt id {}",
                    challenge.getUserAlias(), scoreCard.getScore(),
                    challenge.getAttemptId());
            List<BadgeCard> badgeCards = processForBadges(challenge);
            return new GameResult(scoreCard.getScore(),
                    badgeCards.stream().map(BadgeCard::getBadgeType)
                            .collect(Collectors.toList()));
        } else {
            log.info("Attempt id {} is not correct. User {} does not get score.",
                    challenge.getAttemptId(),
                    challenge.getUserAlias());
            return new GameResult(0, List.of());
        }
    }

    /**
     * Checks the total score and the different scores cards obtained
     * to give new badges in case their conditions are met.
     */
    private List<BadgeCard> processForBadges(final ChallengeSolvedDTO solvedChallenge) {
        Optional<Integer> optTotalScore = scoreRepository.
                getTotalScoreForUser(solvedChallenge.getUserId());
        if (optTotalScore.isEmpty()) return Collections.emptyList();
        int totalScore = optTotalScore.get();

        // Gets the total score and existing badges for that user
        List<ScoreCard> scoreCardList = scoreRepository
                .findByUserIdOrderByScoreTimestampDesc(solvedChallenge.getUserId());
        Set<BadgeType> alreadyGotBadges = badgeRepository
                .findByUserIdOrderByBadgeTimestampDesc(solvedChallenge.getUserId())
                .stream().map(BadgeCard::getBadgeType)
                .collect(Collectors.toSet());

        // Calls the badge processors for badges that the user doesn't have yet
        List<BadgeCard> newBadgeCards = badgeProcessors.stream()
                .filter(bp -> !alreadyGotBadges.contains(bp.badgeType()))
                .map(bp -> bp.processForOptionalBadge(totalScore, scoreCardList, solvedChallenge))
                .flatMap(Optional::stream) // returns an empty stream if empty
                // maps the optionals if present to new BadgeCards
                .map(badgeType -> new BadgeCard(solvedChallenge.getUserId(), badgeType))
                .collect(Collectors.toList());
        // save all new badgecards
        badgeRepository.saveAll(newBadgeCards);

        return newBadgeCards;
    }
}
