import java.util.*;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] required = new int[n];
        for (int i = 0; i < n; i++) {
            required[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(required);

        int fullBags = 0;

        for (int need : required) {
            if (need == 0) { 
                fullBags++; 
                continue; 
            }
            if (additionalRocks >= need) {
                additionalRocks -= need;
                fullBags++;
            } else {
                break;
            }
        }

        return fullBags;
    }
}
