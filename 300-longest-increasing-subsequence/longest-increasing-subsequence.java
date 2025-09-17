class Solution {
    public int lengthOfLIS(int[] arr) {
        if (arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int idx = binarySearch(dp, 0, len - 1, num);
            dp[idx] = num;
            if (idx == len) len++;
        }
        return len;
    }

    private int binarySearch(int[] dp, int si, int ei, int key) {
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (dp[mid] >= key) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return si;
    }
}
