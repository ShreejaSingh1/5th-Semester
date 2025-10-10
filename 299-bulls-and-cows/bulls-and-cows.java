import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        List<Character> secretList = new ArrayList<>();
        List<Character> guessList = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretList.add(secret.charAt(i));
                guessList.add(guess.charAt(i));
            }
        }

        for (char ch : guessList) {
            if (secretList.contains(ch)) {
                cows++;
                secretList.remove((Character) ch); 
            }
        }

        return bulls + "A" + cows + "B";
    }
}
