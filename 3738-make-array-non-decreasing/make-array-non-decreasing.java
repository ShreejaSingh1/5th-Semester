class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = 0;

        for (int x : nums) {
            int curr = x;
            while (top > 0 && stack[top - 1] > curr) {
                curr = Math.max(curr, stack[--top]);
            }
            stack[top++] = curr;
        }
        return top;
    }
}
