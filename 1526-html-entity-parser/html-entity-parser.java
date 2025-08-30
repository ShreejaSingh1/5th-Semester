import java.util.*;

class Solution {
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == '&') {
                if (i + 6 <= n && text.startsWith("&quot;", i)) { sb.append('"'); i += 5; }
                else if (i + 6 <= n && text.startsWith("&apos;", i)) { sb.append('\''); i += 5; }
                else if (i + 5 <= n && text.startsWith("&amp;", i)) { sb.append('&'); i += 4; }
                else if (i + 4 <= n && text.startsWith("&gt;", i)) { sb.append('>'); i += 3; }
                else if (i + 4 <= n && text.startsWith("&lt;", i)) { sb.append('<'); i += 3; }
                else if (i + 7 <= n && text.startsWith("&frasl;", i)) { sb.append('/'); i += 6; }
                else { sb.append('&'); }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
