package co.slzr;

public class Main {

    public static void main(String[] args) {
        Binary bin = new Binary("10111011");

        System.out.println(bin.toString());
        System.out.println(bin.toInt());

        Binary bin2 = new Binary(20);

        System.out.println(bin2.toString());
        System.out.println(bin2.toInt());
    }
}
