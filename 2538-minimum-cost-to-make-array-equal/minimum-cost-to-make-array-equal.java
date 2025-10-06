class Solution {
    public long minCost(int[] nums, int[] cost) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int num : nums){
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while(low < high){
            int mid = low + (high - low)/2;
            long costMid = totalCost(nums, cost, mid);
            long costMidPlus = totalCost(nums, cost, mid+1);

            if(costMid > costMidPlus){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return totalCost(nums, cost, low);
    }

    private long totalCost(int[] nums, int[] cost, int x){
        long res = 0;
        for(int i = 0; i < nums.length; i++){
            res += (long)Math.abs(nums[i] - x) * cost[i];
        }
        return res;
    }
}
