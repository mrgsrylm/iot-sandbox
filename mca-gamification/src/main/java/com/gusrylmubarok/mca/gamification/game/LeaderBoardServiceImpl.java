package com.gusrylmubarok.mca.gamification.game;

import com.gusrylmubarok.mca.gamification.game.domain.LeaderBoardRow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {
    private final ScoreRepository scoreRepository;
    private final BadgeRepository badgeRepository;

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        // Get score only
        List<LeaderBoardRow> scoreOnly = scoreRepository.findFirst10();
        // Combine with badges
        return scoreOnly.stream().map(row -> {
            List<String> badges = badgeRepository
                    .findByUserIdOrderByBadgeTimestampDesc(row.getUserId()).stream()
                            .map(b -> b.getBadgeType().getDescription())
                            .collect(Collectors.toList());
            return row.withBadges(badges);
        }).collect(Collectors.toList());
    }
}
