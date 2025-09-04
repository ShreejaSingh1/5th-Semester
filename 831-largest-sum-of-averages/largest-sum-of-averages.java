class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Double[][] dp = new Double[n][k + 1];
        return helper(0, k, nums, prefix, dp);
    }

    private double helper(int i, int k, int[] nums, double[] prefix, Double[][] dp) {
        int n = nums.length;
        if (dp[i][k] != null) return dp[i][k];
        if (k == 1) {
            dp[i][k] = (prefix[n] - prefix[i]) / (n - i);
            return dp[i][k];
        }
        double best = 0;
        for (int j = i; j < n - (k - 1); j++) {
            double avg = (prefix[j + 1] - prefix[i]) / (j - i + 1);
            best = Math.max(best, avg + helper(j + 1, k - 1, nums, prefix, dp));
        }
        dp[i][k] = best;
        return best;
    }
}
