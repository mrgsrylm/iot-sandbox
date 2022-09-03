package com.gusrylmubarok.multiplicationca.core.challenge;

import com.gusrylmubarok.multiplicationca.core.user.User;
import lombok.*;

import javax.persistence.*;

/**
 * Identifies the attempt fron a {@link com.gusrylmubarok.multiplicationca.core.user.User} to solve a challenge.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}
