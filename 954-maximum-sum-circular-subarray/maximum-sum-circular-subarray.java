// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         public int maxSubArraySum(int[] nums){
//             int max=Integer.MIN_VALUE;
//             int sum-0;
//             for(int i=0;i<nums.length;i++){
//                 sum+=nums[i];
//                 max=Math.max(aum,max);
//                 if(sum<0){
//                     sum=0;
//                 }
//                 return max;
//             }
//         }
//         public int minSubArraySum(int[] nums){
//             int min=nums[0];
//             int sum-0;
//             for(int i=0;i<nums.length;i++){
//                 sum+=nums[i];
//                 min=Math.min(aum,min);
//                 if(sum>0){
//                     sum=0;
//                 }
//                 return min;
//             }
//         }

//     }
// }

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = maxSubArraySum(nums);
        int minSum = minSubArraySum(nums);

        for (int num : nums) {
            total += num;
        }

        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }

    private int maxSubArraySum(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) sum = 0;
        }
        return max;
    }
    private int minSubArraySum(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(sum, min);
            if (sum > 0) sum = 0;
        }
        return min;
    }
}




