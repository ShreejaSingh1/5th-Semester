import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] res = new int[people.length][];
        boolean[] filled = new boolean[people.length];

        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (!filled[i]) {
                    spaces--;
                    if (spaces == 0) {
                        res[i] = person;
                        filled[i] = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
