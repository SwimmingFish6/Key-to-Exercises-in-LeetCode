/**
 * Created by luxuhui on 2018/1/27.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int maxRight = 0;
        int id = 0;
        int pos = 0;
        String newString = "$";

        for(int i = 0;i < s.length();i++) {
            newString += "#" + s.charAt(i);
        }

        newString += "#!";
        int[] RL = new int[newString.length()];

        for(int i = 1;i < newString.length() - 1;i++) {
            if (maxRight > i) {
                RL[i] = RL[2 * pos - i] < maxRight - i?RL[2 * pos - i]:maxRight - i;
            }
            else RL[i] = 1;

            for(;newString.charAt(i - RL[i]) == newString.charAt(i + RL[i]);RL[i]++){
                int x = 0;
            }

            if (i + RL[i] - 1 > maxRight) {
                pos = i;
                maxRight = i + RL[i] - 1;
            }

            if (RL[i] > RL[id]) id = i;
        }

        if (id % 2 == 0) {
            return s.substring((id - 1) / 2 - (RL[id] - 1) / 2, (id + 1) / 2 + (RL[id] - 1) / 2);
        }
        else {
            return s.substring(id / 2 - (RL[id] - 1) / 2, id / 2 + (RL[id] - 1) / 2);

        }

    }
}
