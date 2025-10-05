class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        int[] trusts = new int[n + 1];
        int[] trustedBy = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trusts[a]++;
            trustedBy[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trustedBy[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
