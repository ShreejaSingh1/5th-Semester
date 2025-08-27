class Solution {
    public boolean checkRecord(String s) {
        return s.chars().filter(ch -> ch == 'A').count() < 2 && !s.contains("LLL");
    }
}
