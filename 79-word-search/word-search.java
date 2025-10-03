class Solution {
    public boolean exist(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (search(grid, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] grid, String word, int row, int col, int index) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return false;
        if (grid[row][col] != word.charAt(index)) return false;

        char currentChar = grid[row][col];
        grid[row][col] = '*';

        boolean exists = search(grid, word, row + 1, col, index + 1) ||
                         search(grid, word, row - 1, col, index + 1) ||
                         search(grid, word, row, col + 1, index + 1) ||
                         search(grid, word, row, col - 1, index + 1);

        grid[row][col] = currentChar;

        return exists;
    }
}
