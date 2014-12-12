package io.github.codecougars.slzr;

import java.util.ArrayList;

/**
 * Created by as on 12/12/14.
 */

/*
* This is basically a completely overwritten Binary class.
* It Is always within a maximum of 7 bits memory inefficient.
 */
public class CompactBinary extends Binary {
    byte[] bits;
    public int length;

    /*
    * The get and set bit methods are actually really important in this implementation.
    * Everything is based on them.
    */
    @Override
    public int getBit(int i) {
        int byteIndex = i / 8;
        int bitIndex = i % 8;

        return (bits[byteIndex] >> bitIndex) & 1;
    }

    @Override
    void setBit(int i, int value) {
        int byteIndex = i / 8;
        int bitIndex = i % 8;

        if (!(i > length)) {
            if (value == 1) {
                bits[byteIndex] = (byte) (bits[byteIndex] | 1 << bitIndex);
            }
            else if (value == 0) {
                bits[byteIndex] = (byte) (bits[byteIndex] & ~(1 << bitIndex));
            }
        }
    }

    public CompactBinary(String input) {
        if (!input.matches("[0|1]+")) {
            throw new Error("Invalid input");
        }

        length = input.length();

        int byteLength = length / 8 + 1;

        bits = new byte[byteLength];

        for (int i = (input.length() - 1), j = (length - 1); i >= 0; i--, j--) {
            char bit = input.charAt(i);

            if (bit == '0') {
                setBit(j, 0);
            }
            else if (bit == '1') {
                setBit(j, 1);
            }
        }
    }

    public CompactBinary(int input) {
        int mult = 0;
        while ((Math.pow(2, mult) <= input)) {
            mult++;
        }

        ArrayList<Integer> binary = new ArrayList<Integer>();

        for (int i = mult; i > 0; i--) {
            binary.add(input % 2);
            input = input / 2;
        }

        length = binary.size();

        int byteLength = length / 8 + 1;

        bits = new byte[byteLength];

        for (int i = (length - 1), j = 0; i >= 0; i--, j++) {
            setBit(i, binary.get(j));
        }
    }

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < length; i++) {
            output += getBit(i);
        }

        return output;
    }

    @Override
    public int toInt() {
        int output = 0;

        for (int i = (length - 1), j = 0; i >= 0; i--, j++) {
            if (getBit(i) == 1) {
                output += Math.pow(2, j);
            }
        }

        return output;
    }

    @Override
    public long toLong() {
        long output = 0;

        for (int i = (length - 1), j = 0; i >= 0; i--, j++) {
            if (getBit(i) == 1) {
                output += Math.pow(2, j);
            }
        }

        return output;
    }

    @Override
    public void zeroBits() {
        for (int i = 0; i < length; i++) {
            setBit(i, 0);
        }
    }

    public String getMeta() {
        return "bit length: " + length + "\nbytes used: " + bits.length + "\ncurrent value: " + toString();
    }
}
