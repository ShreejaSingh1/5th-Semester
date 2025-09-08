import java.util.*;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int base = grid[0][0];

        for(int[] row : grid) {
            for(int val : row) {
                if(Math.abs(val - base) % x != 0) return -1;
                nums.add(val);
            }
        }

        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int ops = 0;
        for(int val : nums) {
            ops += Math.abs(val - median) / x;
        }
        return ops;
    }
}
