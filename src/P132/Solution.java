class Solution {
    public int minCut(String s) {
        if (s.length() == 0) return 0;
        int[] cut = new int[s.length()];
        boolean[][] isP = new boolean[s.length()][s.length()];
        
        for (int i = 0;i < s.length();i++) {
            cut[i] = i;
            for (int j = 0;j < s.length() - i;j++) {
                if (s.charAt(j) == s.charAt(j + i) && (i - 1 + j < j + 1 || isP[j + 1][j + i - 1])) {
                    isP[j][j + i] = true;
                }
            }
        }
        
        for (int i = 0;i < s.length();i++) {
            for (int j = i;j < s.length();j++) {
                if (isP[i][j]) {
                    cut[j] =  Math.min(cut[j], i == 0?0:cut[i - 1] + 1);
                }
            }
        }
        
        return cut[s.length() - 1];
    }
}