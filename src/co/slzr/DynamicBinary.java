package co.slzr;

import java.util.ArrayList;

/**
 * Created by AlexanderSelzer1 on 26.11.14.
 */

public class DynamicBinary extends Binary {
    /* `bits` has to be set or errors happen */

    DynamicBinary(String input) {
        if (!input.matches("[0|1]+")) {
            throw new Error("Invalid input");
        }

        bits = new Integer[input.length()];

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

    DynamicBinary(int input) {
        int mult = 0;
        while ((Math.pow(2, mult) <= input)) {
            mult++;
        }

        ArrayList<Integer> binary = new ArrayList<Integer>();

        for (int i = mult; i > 0; i--) {
            binary.add(input % 2);
            input = input / 2;
        }

        bits = new Integer[binary.size()];

        for (int i = (bits.length - 1), j = 0; i >= 0; i--, j++) {
            bits[i] = binary.get(j);
        }

        // make the array list an array and store it as `bits`.
        //bits = binary.toArray(new Integer[binary.size()]);
    }
}