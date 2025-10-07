class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int i = 0, j = length;
            while (i < j) {
                int mid = (i + j) / 2;
                if (sub[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            sub[i] = num;
            if (i == length) length++;
        }

        return length;
    }
}
