class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                int count = countLiveNum(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (count == 2 || count == 3) board[i][j] += 2;
                }
                else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }
        
         for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                board[i][j] >>= 1;
            }
         }
        
        return;
    }
    
    public int countLiveNum(int[][] board, int m, int n) {
        int count = 0;
        for (int i = Math.max(0, m - 1);i <= Math.min(m + 1, board.length - 1);i++) {
            for (int j = Math.max(0, n - 1);j <= Math.min(n + 1, board[0].length - 1);j++) {
                if (m == i && n == j) continue;
                if ((board[i][j] & 1) == 1) count++;
            }
        }
        
        return count;
    }
}