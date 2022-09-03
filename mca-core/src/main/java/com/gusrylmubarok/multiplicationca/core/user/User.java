package com.gusrylmubarok.multiplicationca.core.user;

import lombok.*;

import javax.persistence.*;

/**
 * Stores information to identify the user.
 */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;

    public User(final String userAlias) {
        this(null, userAlias);
    }
}
