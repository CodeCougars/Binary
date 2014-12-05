package co.slzr;

public class Main {

    public static void main(String[] args) {
        Binary bin = new Binary("10111011");

        System.out.println(bin.toString());
        System.out.println(bin.toInt());

        Binary bin2 = new Binary(20);

        System.out.println(bin2.toString());
        System.out.println(bin2.toInt());

        try {
            Binary bad = new Binary("00100022201");
        }
        catch (Error err) {
            System.out.println(err);
        }

        try {
            Binary bad = new Binary("00000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000011000000000000000000000000000");
        }
        catch (Error err) {
            System.out.println(err);
        }
    }
}
