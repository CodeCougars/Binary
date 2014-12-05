public class BinaryAlen
{
    private int[] binary = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    BinaryAlen(int dec) {
        for (int biNum = binary.length - 1; biNum >= 0; biNum--) {
            binary[biNum] = dec % 2;
            dec = dec / 2;
        }

        showBinary();
    }

    BinaryAlen(String biInput) {
        for (int l = (biInput.length() - 1 ), j = (binary.length - 1); l >= 0; l--, j--) {
            char bit = biInput.charAt(l);

            if (bit == '0') {
                binary[j] = 0;
            }

            else if (bit == '1') {
                binary[j] = 1;
            }
        }
    }

    public String showBinary() {
        String ans = "";
        for (int biNum = binary.length - 1; biNum >= 0; biNum--) {
            ans = binary[biNum] + ans;
        }
        System.out.println(ans);
        return ans;
    }

    public int toDecimal() {
        int decimal = 0;
        int i = 0;
        for (int biNum = binary.length - 1, m = 1; biNum >= 0; biNum--, m = m * 2) {
            i = binary[biNum];
            i = i * m;
            decimal = decimal + i;
        }
        return decimal;
    }

    public String toString() {
        String out = "";

        for (int bit : binary) {
            out += bit;
        }

        return out;
    }
}
