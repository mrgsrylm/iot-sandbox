package com.gusrylmubarok.mca.gamification.game.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@AllArgsConstructor
public class LeaderBoardRow {
    Long userId;
    Long totalScore;
    @With
    List<String> badges;

    public LeaderBoardRow(final Long userId, final Long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.badges = List.of();
    }
}
