class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        set.add(n);
        
        while (true) {
            int tmp = 0;
            
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n = n / 10;
            }
            
            if (tmp == 1) return true;

            if (set.contains(tmp)) break;
            else set.add(tmp);
            
            n = tmp;
        }
        
        return false;
    }
}