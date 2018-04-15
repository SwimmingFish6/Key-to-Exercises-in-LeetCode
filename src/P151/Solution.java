public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        
        int left = 0, right = s.length() - 1;
        char[] charArray = s.toCharArray();
        
        while (left < right) {
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
            left++;
            right--;
        }
        
        
        int pre = 0, cur = 0;
        
        while (true) {
            while (pre < charArray.length && charArray[pre] == ' ') {
                pre++;
                cur++;
            }
            
            if (pre >= charArray.length) {
                break;
            }
            
            while (cur + 1 < charArray.length && charArray[cur + 1] != ' ') {
                cur++;
            }
            
            left = pre;
            right = cur;
            
            while (left < right) {
                char tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left++;
                right--;
            }
            
            cur++;
            pre = cur;
        }
        
        
        
        return cleanSpaces(charArray, charArray.length);
    }
    
    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        
        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }
        
        return new String(a).substring(0, i);
    }
}
