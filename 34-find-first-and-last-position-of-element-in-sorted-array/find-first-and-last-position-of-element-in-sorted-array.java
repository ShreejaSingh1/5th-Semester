class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startpos=Start(nums,target);
        int endpos=End(nums,target);
        return new int[]{startpos,endpos};
    }
    private int Start(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            if(nums[mid]==target){
                ans=mid;
            }
        }
            return ans;
        }
        private int End(int[] nums,int target){
            int low=0;
            int high=nums.length-1;
            int ans=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]<=target){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
                if(nums[mid]==target){
                    ans=mid;
                }
            }
                return ans;
    }
}