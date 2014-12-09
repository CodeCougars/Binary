package io.github.codecougars.slzr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AlexanderSelzer1 on 26.11.14.
 */

public class Binary {
    public Integer[] bits;

    public String toString() {
        String output = "";

        for (int bit : bits) {
            output += bit;
        }

        return output;
    }

    public int toInt() {
        int output = 0;

        for (int i = (bits.length - 1), j = 0; i >= 0; i--, j++) {
            if (bits[i] == 1) {
                output += Math.pow(2, j);
            }
        }

        return output;
    }

    public long toLong() {
        long output = 0;

        for (int i = (bits.length - 1), j = 0; i >= 0; i--, j++) {
            if (bits[i] == 1) {
                output += Math.pow(2, j);
            }
        }

        return output;
    }

    public void zeroBits() {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 0;
        }
    }

    static boolean isValid(String input) {
        return input.matches("[0|1]+");
    }
}