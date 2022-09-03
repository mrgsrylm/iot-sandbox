package com.gusrylmubarok.mca.gamification.game.badgeprocessors;

import com.gusrylmubarok.mca.gamification.challenge.ChallengeSolvedDTO;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeType;
import com.gusrylmubarok.mca.gamification.game.domain.ScoreCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FirstWonBadgeProcessor implements BadgeProcessor {
    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore, List<ScoreCard> scoreCardList,
                                                       ChallengeSolvedDTO solved) {
        return scoreCardList.size() == 1 ? Optional.of(BadgeType.FIRST_WON) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.FIRST_WON;
    }
}
