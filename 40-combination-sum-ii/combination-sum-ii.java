import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Set<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) dp.add(new HashSet<>());
        dp.get(0).add(new ArrayList<>());

        for (int num : candidates) {
            for (int t = target; t >= num; t--) {
                for (List<Integer> prev : dp.get(t - num)) {
                    List<Integer> newList = new ArrayList<>(prev);
                    newList.add(num);
                    dp.get(t).add(newList);
                }
            }
        }

        return new ArrayList<>(dp.get(target));
    }
}
