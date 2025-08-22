class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        int len = 1;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
        int dir = 0;
        int r = rStart, c = cStart;
        
        result[count++] = new int[]{r, c};
        
        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int step = 0; step < len; step++) {
                    r += directions[dir][0];
                    c += directions[dir][1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[]{r, c};
                        if (count == rows * cols) return result;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
        
        return result;
    }
}
