class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1]; // 1-indexed
        backtrack(n, 1, used);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % pos == 0 || pos % num == 0)) {
                used[num] = true;
                backtrack(n, pos + 1, used);
                used[num] = false; // backtrack
            }
        }
    }
}
