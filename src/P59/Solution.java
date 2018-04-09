class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int count = 1;
        
        while (count <= n * n) {
            for (int i = left;i <= right;i++) res[top][i] = count++;
            top++;
            // if (count > n * n) break;
            
            for (int i = top;i <= bottom;i++) res[i][right] = count++;
            right--;
            // if (count > n * n) break;
            
            for (int i = right;i >= left;i--) res[bottom][i] = count++;
            bottom--;
            // if (count > n * n) break;
            
            for (int i = bottom;i >= top;i--) res[i][left] = count++;
            left++;
            // if (count > n * n) break;
        }
        
        return res;
    }
}
