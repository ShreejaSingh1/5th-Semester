class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        int gold = grid[i][j];
        grid[i][j] = 0; // mark visited

        int maxPath = 0;
        maxPath = Math.max(maxPath, dfs(grid, i + 1, j)); // down
        maxPath = Math.max(maxPath, dfs(grid, i - 1, j)); // up
        maxPath = Math.max(maxPath, dfs(grid, i, j + 1)); // right
        maxPath = Math.max(maxPath, dfs(grid, i, j - 1)); // left

        grid[i][j] = gold; // backtrack
        return gold + maxPath;
    }
}
