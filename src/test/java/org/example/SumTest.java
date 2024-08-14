package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Sum.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        var result = sum(2, 3);
        assertEquals(5, result);
    }
}