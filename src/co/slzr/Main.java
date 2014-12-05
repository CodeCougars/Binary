package co.slzr;

public class Main {

    public static void main(String[] args) {

        System.out.println("new Binary32(67)");
        Binary test1 = new Binary32(255);

        System.out.println(test1.toString());
        System.out.println(test1.toInt());

        System.out.println("new DynamicBinary(67)");
        Binary test2 = new DynamicBinary(255);

        System.out.println(test2.toString());
        System.out.println(test2.toInt());


        /* Binary string input */

        System.out.println("new DynamicBinary('11111111')");
        Binary bin = new DynamicBinary("11111111");

        System.out.println(bin.toString());
        System.out.println(bin.toInt());

        System.out.println("new DynamicBinary('10111011100000100100101111110010100101011111000000111')");
        Binary bin2 = new DynamicBinary("10111011100000100100101111110010100101011111000000111");

        System.out.println(bin2.toString());
        System.out.println(bin2.toInt());

        /* Integer Input */

        System.out.println("new DynamicBinary(20)");
        Binary bin3 = new DynamicBinary(64);

        System.out.println(bin3.toString());
        System.out.println(bin3.toInt());

        System.out.println("new DynamicBinary(26262920)");
        Binary bin4 = new DynamicBinary(26262920);

        System.out.println(bin4.toString());
        System.out.println(bin4.toInt());

        /* Problematic input */

        System.out.println("new DynamicBinary('00100022201')");
        try {
            Binary bad = new DynamicBinary("00100022201");
        }
        catch (Error err) {
            System.out.println(err);
        }
    }
}
