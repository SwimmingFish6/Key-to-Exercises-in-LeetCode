import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";


        int min_length = strs[0].length();

        for (int i = 1;i < strs.length;i++) {
            min_length = Math.min(min_length, strs[i].length());
        }

        if (min_length == 0) return "";

        for (int i = 0;i < min_length;i++) {
            char c = strs[0].charAt(i);
            for (int j = 1;j < strs.length;j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, min_length);
    }
}