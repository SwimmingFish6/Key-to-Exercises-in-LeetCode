class Solution {
    public List<List<String>> partition(String s) {
        return dfs(s, 0);
    }
    
    public List<List<String>> dfs(String s, int start) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if (s.length() == start) {
            res.add(new ArrayList<String>());
            return res;
        }
        
        for (int i = start + 1;i <= s.length();i++) {
            if (!isPalindrome(s, start, i)) continue;
            
            List<List<String>> tmp = dfs(s, i);
            
            for (int j = 0;j < tmp.size();j++) {
                tmp.get(j).add(0, s.substring(start, i));
            }
            
            res.addAll(tmp);
        }
        
        return res;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        int left = start, right = end - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}