class Solution {
    public int minInsertions(String s) {
        int open = 0;      
        int insertions = 0; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else { 
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) {
                        open--; 
                    } else {
                        insertions++; 
                    }
                    i++; 
                } else {
                    if (open > 0) {
                        open--; 
                        insertions++; 
                    } else {
                        insertions += 2; 
                    }
                }
            }
        }

        insertions += open * 2;

        return insertions;
    }
}
