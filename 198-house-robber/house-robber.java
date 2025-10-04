class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int incl = 0;
        int excl = 0;
        for (int i = 0; i < nums.length; i++) {
            int newIncl = excl + nums[i];
            int newExcl = Math.max(incl, excl);
            incl = newIncl;
            excl = newExcl;
        }
        return Math.max(incl, excl);
    }
}
