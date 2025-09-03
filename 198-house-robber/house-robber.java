class Solution {
    public int rob(int[] nums) {
        return robber3(nums);
    }
    public static int robber3(int a[]) {
			if(a.length==1) return a[0];
			int dp[]=new int[a.length];
			dp[0]=a[0];
			dp[1]=Math.max(a[0], a[1]);
			for(int i=2;i<dp.length;i++) {
				int rob=a[i]+dp[i-2];
				int dont=dp[i-1];
				dp[i]=Math.max(rob, dont);
			}
			return dp[dp.length-1];
			
		}
}