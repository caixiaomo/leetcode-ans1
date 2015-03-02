/*
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).

 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"

 * Minimum window is "BANC".

 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the emtpy string "".

 * If there are multiple such windows, you are guaranteed that 
 * there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        String result = "";
        int[] hasFound = new int[256];
        int[] needFound = new int[256];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < T.length(); i++) {
            needFound[T.charAt(i)]++;
        }
        for (int start = 0, end = 0; end < S.length(); end++) {
            if (needFound[S.charAt(end)] == 0)
                continue;
            hasFound[S.charAt(end)]++;
            if (hasFound[S.charAt(end)] <= needFound[S.charAt(end)])
                count++;
            if (count == T.length()) {
                while (needFound[S.charAt(start)] == 0 || 
                        needFound[S.charAt(start)] < hasFound[S.charAt(start)]) {
                    if (needFound[S.charAt(start)] < hasFound[S.charAt(start)]) {
                        hasFound[S.charAt(start)]--;
                    }
                    start++;
                }
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    result = S.substring(start, end + 1);
                }
            }
        } 
        return result;
    }

}
