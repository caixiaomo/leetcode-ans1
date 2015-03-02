/*
 * Given two binary strings, return their sum (also a binary string).

 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        String res = "";
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int ca = i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
            int cb = i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;
            res = (ca + cb + carry) % 2 + res;
            carry = (ca + cb + carry) / 2;
        }
        if (carry > 0)
            res = carry + res;
        return res;
    }
}
