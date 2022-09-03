package com.gusrylmubarok.multiplicationca.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * This class represents a Multiplication (a * b).
 */
@Entity
@RequiredArgsConstructor
@Getter @ToString
@EqualsAndHashCode
public final class Multiplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MULTIPLICATION_ID")
    private Long id;
    private final int factorA;
    private final int factorB;

    // Empty constructor for JSON (de)serialization
    Multiplication() {
        this(0, 0);
    }
}
