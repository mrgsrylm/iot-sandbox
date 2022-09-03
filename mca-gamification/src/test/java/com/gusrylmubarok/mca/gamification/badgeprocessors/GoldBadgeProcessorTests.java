package com.gusrylmubarok.mca.gamification.badgeprocessors;

import com.gusrylmubarok.mca.gamification.game.badgeprocessors.GoldBadgeProcessor;
import com.gusrylmubarok.mca.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GoldBadgeProcessorTests {
    private GoldBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new GoldBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(450, List.of(), null);
        assertThat(badgeType).contains(BadgeType.GOLD);
    }

    @Test
    public void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(350, List.of(), null);
        assertThat(badgeType).isEmpty();
    }
}
