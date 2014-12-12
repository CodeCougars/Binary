package io.github.codecougars.slzr;

/**
 * Created by as on 12/12/14.
 */
public class CompactBinaryTest {
    public static void main(String[] args) {
        CompactBinary ob = new CompactBinary("10101010");

        System.out.println(ob.toString());
        System.out.println(ob.toInt());
        System.out.println(ob.getMeta());

        CompactBinary ob2 = new CompactBinary("1010101011111100000");

        System.out.println(ob2.toString());
        System.out.println(ob2.getMeta());

        CompactBinary intOb = new CompactBinary(402121221);

        System.out.println(intOb.toString());
        System.out.println(intOb.toInt());
        System.out.println(intOb.toLong());
        System.out.println(intOb.getMeta());

        intOb.zeroBits();

        System.out.println(intOb.toInt());
        System.out.println(intOb.toString());
    }
}
