package co.slzr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AlexanderSelzer1 on 26.11.14.
 */

public class Binary32 extends Binary {
    Binary32(String input) {
        bits = new Integer[32];
        zeroBits();

        if (!input.matches("[0|1]+")) {
            throw new Error("Invalid input");
        }

        if (input.length() > bits.length) {
            throw new Error("Input can not be larger than " + bits.length);
        }

        for (int i = (input.length() - 1), j = (bits.length - 1); i >= 0; i--, j--) {
            char bit = input.charAt(i);

            if (bit == '0') {
                bits[j] = 0;
            }
            else if (bit == '1') {
                bits[j] = 1;
            }
        }
    }

    Binary32(int input) {
        bits = new Integer[32];
        zeroBits();

        for (int i = (bits.length - 1); i >= 0; i--) {
            bits[i] = input % 2;
            input = input / 2;
        }
    }
}
