class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        boolean[][] map = new boolean[grid.length][grid[0].length];
        int res = 0;
        
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                if (grid[i][j] == '1' && !map[i][j]) {
                    dfs(grid, map, i, j);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] grid, boolean[][] map, int i, int j) {
        map[i][j] = true;
        
        if (i > 0 && grid[i - 1][j] == '1' && !map[i - 1][j]) dfs(grid, map, i - 1, j);
        
        if (j > 0 && grid[i][j - 1] == '1' && !map[i][j - 1]) dfs(grid, map, i, j - 1);
        
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !map[i + 1][j]) dfs(grid, map, i + 1, j);

        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !map[i][j + 1]) dfs(grid, map, i, j + 1);
    }
}