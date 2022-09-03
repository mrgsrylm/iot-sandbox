package com.gusrylmubarok.mca.gamification.game;

import com.gusrylmubarok.mca.gamification.challenge.ChallengeSolvedDTO;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeType;
import lombok.Value;

import java.util.List;

public interface GameService {
    /**
     * Process a new attempt from a given user.
     * @param challenge the challenge data with user details, factors, etc.
     * @return a {@link GameResult} object containing the new score and badge
     * cards obtained
     */
    GameResult newAttemptForUser(ChallengeSolvedDTO challenge);

    @Value
    class GameResult {
        int score;
        List<BadgeType> badges;
    }
}
