class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.insert(0, (char) (n % 26 != 0?'A' + n % 26 - 1:'Z'));
            n = n % 26 == 0?(n - 26) / 26:(n - n % 26) / 26;
        }
        
        return sb.toString();
    }
}