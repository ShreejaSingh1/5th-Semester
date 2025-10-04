class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans,list,candidates,target,0,0);
        return ans;
    }

    public void helper(List<List<Integer>>ans,List<Integer>list,int arr[],int tar,int idx, int sum){
        if(sum==tar){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx>=arr.length || sum>tar){
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){continue;}
            list.add(arr[i]);
            helper(ans,list,arr,tar,i+1,sum+arr[i]);
            list.remove(list.size()-1);
        }
    }
}