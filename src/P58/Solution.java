class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int length = 0;
        int end = s.length() - 1;
        
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        
        for (int i = end;i >= 0;i--) {
            if (s.charAt(i) == ' ') break;
            length++;
            
        }
        
        return length;
    }
}
