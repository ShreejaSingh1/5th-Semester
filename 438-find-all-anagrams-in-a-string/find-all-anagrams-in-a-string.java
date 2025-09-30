import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char ch : p.toCharArray()) c1[ch - 'a']++;

        int w = p.length();
        for (int i = 0; i < s.length(); i++) {
            c2[s.charAt(i) - 'a']++;
            if (i >= w) c2[s.charAt(i - w) - 'a']--;
            if (matches(c1, c2)) res.add(i - w + 1);
        }
        return res;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) if (a[i] != b[i]) return false;
        return true;
    }
}
