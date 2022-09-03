package com.gusrylmubarok.mca.gamification.challenge;

import lombok.Value;

@Value
public class ChallengeSolvedDTO {
    long attemptId;
    boolean corrent;
    int factorA;
    int factorB;
    long userId;
    String userAlias;
}
