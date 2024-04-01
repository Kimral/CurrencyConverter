package com.usue.svetlyakov.coursework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloApplicationTest {
    @Test
    @DisplayName("Multiply two numbers")
    void multiply() {
        assertAll(() -> assertEquals(4, HelloApplication.multiply(2, 2)),
                () -> assertEquals(-4, HelloApplication.multiply(2, -2)),
                () -> assertEquals(4, HelloApplication.multiply(-2, -2)),
                () -> assertEquals(0, HelloApplication.multiply(1, 0)));
    }
}