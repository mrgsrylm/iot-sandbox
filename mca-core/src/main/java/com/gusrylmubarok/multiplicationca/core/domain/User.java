package com.gusrylmubarok.multiplicationca.core.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Stores information to identify the user.
 */
@Entity
@Table(name = "users")
@RequiredArgsConstructor
@Getter @ToString
@EqualsAndHashCode
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private final String alias;

    // Empty constructor for JSON (de)serialization
    protected User() {
        alias = null;
    }
}
