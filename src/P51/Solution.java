class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        
        solveStep(res, cur, n, 0);
        
        return res;
    }
    
    public void solveStep(List<List<String>> res, List<String> cur, int n, int step) {
        StringBuilder line = new StringBuilder();
        
        for (int i = 0;i < n;i++) {
            line.append('.');
        }
        
        for (int i = 0;i < n;i++) {
            line.replace(i, i + 1, "Q");
            if (isValid(cur, step, i, n)) {
                if (step == n - 1) {
                    cur.add(line.toString());
                    res.add(new ArrayList<String>(cur));
                    cur.remove(step);
                    return;
                }
                else {
                    cur.add(line.toString());
                    solveStep(res, cur, n, step + 1);
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
