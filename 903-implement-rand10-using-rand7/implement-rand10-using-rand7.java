/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
import java.util.Random;

class RandomAPI {
    private static Random random = new Random();

    public static int rand7() {
        return random.nextInt(7) + 1; 
    }
}

class Solution {
    public int rand10() {
        while (true) {
            int num = (RandomAPI.rand7() - 1) * 7 + RandomAPI.rand7(); 
            if (num <= 40) {
                return (num - 1) % 10 + 1; 
            }
        }
    }
}
