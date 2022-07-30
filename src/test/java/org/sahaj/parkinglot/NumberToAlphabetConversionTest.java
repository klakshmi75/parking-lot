package org.sahaj.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberToAlphabetConversionTest {

    @Test
    public void negativeNumberShouldThrowException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            NumberToAlphabetConversion.getAlphabetSequence(-1);
        });
        assertEquals(ErrorConstants.ERROR_NON_POSITIVE_NUMBER, exception.getMessage());
    }

    @Test
    public void numberZeroShouldThrowException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            NumberToAlphabetConversion.getAlphabetSequence(0);
        });
        assertEquals(ErrorConstants.ERROR_NON_POSITIVE_NUMBER, exception.getMessage());
    }

    @Test
    public void testRandomNumbers() {
        assertEquals("A", NumberToAlphabetConversion.getAlphabetSequence(1));
        assertEquals("J", NumberToAlphabetConversion.getAlphabetSequence(10));
        assertEquals("Z", NumberToAlphabetConversion.getAlphabetSequence(26)); // 26 (1 letter combinations)
        assertEquals("AA", NumberToAlphabetConversion.getAlphabetSequence(27));
        assertEquals("ZZ", NumberToAlphabetConversion.getAlphabetSequence(702)); // 676 (2 letter combinations 26^2) + 26 (1 letter combinations)
        assertEquals("AAA", NumberToAlphabetConversion.getAlphabetSequence(703));
        assertEquals("ZZZ", NumberToAlphabetConversion.getAlphabetSequence(18278)); // 17576 (3 letter combinations 26^3) + 676 (2 letter combinations 26^2) + 26 (1 letter combinations)
        assertEquals("AAAA", NumberToAlphabetConversion.getAlphabetSequence(18279));
        assertEquals("ZZZZ", NumberToAlphabetConversion.getAlphabetSequence(475254)); // 456976 (4 letter combinations 26^4) + 17576 (3 letter combinations 26^3) + 676 (2 letter combinations 26^2) + 26 (1 letter combinations)
        assertEquals("AAAAA", NumberToAlphabetConversion.getAlphabetSequence(475255));
    }

    @Test
    public void printAllTill1000() {
        for(int i= 1 ; i <= 1000 ; i++) {
            System.out.println(i + " - " + NumberToAlphabetConversion.getAlphabetSequence(i));
        }
    }
}