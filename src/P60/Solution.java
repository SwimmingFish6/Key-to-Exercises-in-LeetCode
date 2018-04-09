
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1;i <= n;i++) sb.append(i);
        
        getKthPermutation(n, k, sb, 0);
        
        return sb.toString();
    }
    
    public void getKthPermutation(int n, int k, StringBuilder sb, int begin) {
        if (n == 1 || k == 1) {
            return;
        }
        
        int factorial = getFactorialSum(n - 1);
        
        int rank = (k - 1) / factorial;
        int remain = (k - 1) % factorial;
        
        if (rank != 0) {
            char temp = sb.charAt(begin + rank);
            sb.deleteCharAt(begin + rank);
            sb.insert(begin, temp);
        }
        getKthPermutation(n - 1, remain + 1, sb, begin + 1);
    }
    
    private static int getFactorialSum(int n){
        if (n < 0) {
            throw new IllegalArgumentException("x must be>=0");
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
