import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> subs = new ArrayList<>();
        int balance = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '1' ? 1 : -1;
            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                subs.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }
        Collections.sort(subs, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String sub : subs) sb.append(sub);
        return sb.toString();
    }
}
