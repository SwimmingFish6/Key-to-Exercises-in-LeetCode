class Solution {
    public String shortestPalindrome(String s) {        
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        String newStr = s + '#' + sb.reverse().toString();
        int[] table = new int[newStr.length()];
        
        for (int i = 1;i < newStr.length();i++) {
            while (max > 0 && newStr.charAt(max) != newStr.charAt(i)) {
                max = table[max - 1];
            }
            
            if (newStr.charAt(i) == newStr.charAt(max)) max++;
            
            table[i] = max;
        }
        
        StringBuilder tmp = new StringBuilder(s.substring(max));
                    
        return tmp.reverse() + s;                    
        
    }
    
}