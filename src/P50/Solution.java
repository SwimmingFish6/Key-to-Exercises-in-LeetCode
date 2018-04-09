class Solution {
    public double myPow(double x, int n) {
        boolean flag = true;
        
        if (n < 0) {
            n = -n;
            flag = false;
        }
        
        return flag?pow(x, n):1 / pow(x, n);
    }
    
    double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        int pow = 1;
        double res = x;
        
        int left = n - 1;
        
        while (left > pow ) {
            res = res * res;
            pow = pow * 2;
            left = n - pow;
        }
        
        return res * pow(x, left);
    }
}
