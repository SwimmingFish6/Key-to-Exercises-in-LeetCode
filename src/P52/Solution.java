class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        List<String> cur = new ArrayList<String>();
        
        
        dfs(cur, n, 0);
        
        return count;
    }
    
    
    public void dfs(List<String> cur, int n, int step) {
        StringBuilder line = new StringBuilder();
        
        for (int i = 0;i < n;i++) {
            line.append('.');
        }
        
        for (int i = 0;i < n;i++) {
            line.replace(i, i + 1, "Q");
            if (isValid(cur, step, i, n)) {
                if (step == n - 1) {
                    count++;
                    return;
                }
                else {
                    cur.add(line.toString());
                    dfs(cur, n, step + 1);
                    cur.remove(step);
                }
            }
            line.replace(i, i + 1, ".");
        }
        
    }
    
    public boolean isValid(List<String> cur, int step, int pos, int n) {
        for (int i = 0;i < step;i++) {
            if (cur.get(i).charAt(pos) != '.')
                return false;
        }
        
        for (int i = step - 1;i >= 0;i--) {
            if (pos - step + i >= 0 && cur.get(i).charAt(pos - step + i) != '.')
                return false;
            if (pos + step - i < n && cur.get(i).charAt(pos + step - i) != '.')
                return false;
        }
        
        return true;
    }
}
