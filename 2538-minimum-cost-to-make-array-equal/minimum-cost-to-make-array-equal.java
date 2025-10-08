class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int x : nums) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        long ans = totalCost(nums, cost, nums[0]);

        while (low < high) {
            int mid = low + (high - low) / 2;
            long cost1 = totalCost(nums, cost, mid);
            long cost2 = totalCost(nums, cost, mid + 1);

            ans = Math.min(cost1, cost2);

            // Move towards the smaller cost side
            if (cost1 < cost2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long totalCost(int[] nums, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return total;
    }
}
