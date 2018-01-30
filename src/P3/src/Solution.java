/**
 * Created by luxuhui on 2018/1/27.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 1;
        int maxLength = right - left;

        if (s.isEmpty()) return 0;

        while (right < s.length()) {
            for (int i = left; i < right;i++) {
                if (s.charAt(i) == s.charAt(right)) {
                    left = i + 1;
                    break;
                }
            }

            if (right - left + 1 > maxLength) maxLength = right - left + 1;

            right++;
        }

        return maxLength;
    }
}
