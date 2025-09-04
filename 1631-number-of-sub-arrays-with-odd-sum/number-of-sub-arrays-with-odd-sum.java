class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int even = 1, odd = 0;
        long ans = 0, sum = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
            ans %= MOD;
        }

        return (int) ans;
    }
}
