public class Binary
{
    private int[] binary; //= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    int deci = 0;
    
    Binary (int dec) { 
        int n = 0;
        deci = dec;
        String length = "";
        while (dec > 0) {
            n = dec % 2;
            length = length + n;
            dec = dec / 2;
        }
        System.out.println(length);
        binary = new int[length.length()];
        
        for (int biNum = binary.length - 1; biNum >= 0; biNum--) {
            binary[biNum] = deci % 2;
            deci = deci / 2;
        }
    }
    
    /*
    Binary (int dec) {
        for (int biNum = binary.length - 1; biNum >= 0; biNum--) {
            binary[biNum] = dec % 2;
            dec = dec / 2;
        }
 
        showBinary();
    }
    */
 
    Binary(String biInput) {
        binary = new int[biInput.length()];
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
 
    public long toDecimal() {
        long decimal = 0;
        long i = 0;
        for (int biNum = binary.length - 1, m = 1; biNum >= 0; biNum--, m = m * 2) {
            i = binary[biNum];
            i = i * m;
            decimal = decimal + i;
            System.out.println(i);
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
