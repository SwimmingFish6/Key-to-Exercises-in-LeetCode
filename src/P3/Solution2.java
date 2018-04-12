public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = right - left;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
                map.put(s.charAt(right), right);
            }
            
            map.put(s.charAt(right), right);
            
            
            right++;
            if (right - left > maxLength) maxLength = right - left;
        }
        
        
        return maxLength;
    }
}


