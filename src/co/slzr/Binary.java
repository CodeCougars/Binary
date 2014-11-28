package co.slzr;

/**
 * Created by AlexanderSelzer1 on 26.11.14.
 */

public class Binary {
    private int[] bits = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    Binary(String input) {
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

    Binary(int input) {
        for (int i = (bits.length - 1); i >= 0; i--) {
            bits[i] = input % 2;
            input = input / 2;
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
}
