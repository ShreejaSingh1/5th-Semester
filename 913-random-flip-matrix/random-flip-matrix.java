import java.util.*;

class Solution {
    private int m, n, total;
    private Map<Integer, Integer> map;
    private Random rand;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    public int[] flip() {
        int r = rand.nextInt(total--); 
        int x = map.getOrDefault(r, r); 
        map.put(r, map.getOrDefault(total, total)); 
        return new int[]{x / n, x % n}; 
    }

    public void reset() {
        total = m * n;
        map.clear();
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */