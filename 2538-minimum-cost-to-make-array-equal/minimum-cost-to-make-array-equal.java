import java.util.*;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        long totalCost = 0;
        for(int c : cost) totalCost += c;

        long acc = 0;
        int target = 0;
        for(int i = 0; i < n; i++){
            acc += arr[i][1];
            if(acc * 2 >= totalCost){
                target = arr[i][0];
                break;
            }
        }

        long result = 0;
        for(int i = 0; i < n; i++){
            result += (long)Math.abs(nums[i] - target) * cost[i];
        }

        return result;
    }
}
