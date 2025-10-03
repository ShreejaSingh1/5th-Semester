class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        int n=nums.length;
        l.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int s=l.size();
            for(int j=0;j<s;j++){
                List<Integer> subset = new ArrayList<>(l.get(j));
                subset.add(nums[i]);
                l.add(subset);
            }
        }
        return l;
    }
}
















// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         int n = nums.length;
        
//         // add empty subset
//         result.add(new ArrayList<>());

//         for (int i = 0; i < n; i++) {
//             int size = result.size();
//             for (int j = 0; j < size; j++) {
//                 List<Integer> subset = new ArrayList<>(result.get(j));
//                 subset.add(nums[i]);
//                 result.add(subset);
//             }
//         }
        
//         return result;
//     }
// }
