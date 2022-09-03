package com.gusrylmubarok.mca.gamification.game.badgeprocessors;

import com.gusrylmubarok.mca.gamification.challenge.ChallengeSolvedDTO;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeType;
import com.gusrylmubarok.mca.gamification.game.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public interface BadgeProcessor {
    /**
     * Processes some or all of the passed parameters and decides if the user is entitled to a badge.
     * @return a BadgeType if the user is entitled to this badge, otherwise empty
     */
    Optional<BadgeType> processForOptionalBadge(int currentScore, List<ScoreCard> scoreCardList, ChallengeSolvedDTO solved);

    /**
     * @return the BadgeType object that this processor is handling. You can use
     * it to filter processors according to your needs.
     */
    BadgeType badgeType();
}
