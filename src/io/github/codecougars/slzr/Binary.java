package io.github.codecougars.slzr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AlexanderSelzer1 on 26.11.14.
 */

public abstract class Binary {
    public Integer[] bits;

    class InvalidInputException extends Exception {
        public InvalidInputException(String msg) {
            super(msg);
        }
    }

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

    public int getBit(int i) {
        if (!(i > bits.length)) {
            return bits[i];
        }
        else {
            return 0;
        }
    }

    void setBit(int i, int value) {
        if (value == 0 || value == 1 && !(i > bits.length)) {
            bits[i] = value;
        }
    }

    static boolean isValid(String input) {
        return input.matches("[0|1]+");
    }


    // unrelated stuff

    static int[] binaryThing(int[] input) {
        int[] output = new int[2];

        int b1 = input[0];
        int b2 = input[1];
        int bc = input[2];

        int sum = b1 + b2 + bc;
        int carry = sum % 2;

        return new int[]{sum / 2, carry};
    }

    public static void binaryThings() {
        int[][] thingies = {
                {0,0,0},
                {0,0,1},
                {0,1,0},
                {0,1,1},
                {1,0,0},
                {1,0,1},
                {1,1,0},
                {1,1,1}
        };

        for (int[] thingie : thingies) {
            int[] res = binaryThing(thingie);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}