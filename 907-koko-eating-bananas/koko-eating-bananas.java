class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=sumMax(piles);
        
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
        public boolean possible(int[] piles,int mid,int h){
             long sum=0;
             for(int i=0;i<piles.length;i++){
               //sum+=(piles[i]+mid-1)/mid;
               sum+=piles[i]/mid;
               if(piles[i]%mid!=0) sum++;

             }
             if(sum<=h){
                return true;
             }
                return false;
             
        }
        
        public int sumMax(int arr[]){
            int max=arr[0];
            for(int i=0;i<arr.length;i++){
                max=Math.max(arr[i],max);
            }
            return max;
        }
    
}