package org.sahaj.parkinglot;

/**
 * This utility class helps to get alphabet sequence for given positive integer
 */
public class NumberToAlphabetConversion {
    /**
     * Utility method to generate alphabet sequence for given positive integer.
     *
     * @param number - positive integer to which alphabet sequence should be generated
     * @return alphabet sequence
     * @throws RuntimeException for zero and negative numbers
     */
    public static String getAlphabetSequence(int number) {
        if(number <= 0) {
            throw new RuntimeException(ErrorConstants.ERROR_NON_POSITIVE_NUMBER);
        }
        if(number > 26) {
            int bal = number%26 != 0 ? number%26 : 26;
            return getAlphabetSequence((number-bal)/26) + getChar(bal);
        }
        return getChar(number);
    }

    private static String getChar(int num) {
        return Character.toString((char)(64 + num));
    }
}
