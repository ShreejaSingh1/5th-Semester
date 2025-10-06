public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;

        for (int j = p.length() - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                match[s.length()][j] = true;
            } else {
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if (pc == '?' || pc == sc) {
                    match[i][j] = match[i + 1][j + 1];
                } else if (pc == '*') {
                    match[i][j] = match[i][j + 1] || match[i + 1][j];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[0][0];
    }
}
























