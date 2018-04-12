class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append( ((numerator > 0) ^ (denominator > 0))?"-":"");
        
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        
        sb.append(n / d);
        
        long remain = n % d;
        
        if (remain == 0) return sb.toString();
        
        sb.append('.');
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        
        map.put(remain, sb.length());
        
        while (remain != 0) {
            remain *= 10;
            sb.append(remain / d);
            
            remain %= d;
            
            if (map.containsKey(remain)) {
                int index = map.get(remain);
                
                sb.insert(index, '(');
                sb.append(')');
                break;
            }
            else {
                map.put(remain, sb.length());
            }
            
        }
        
        return sb.toString();
    }
}
