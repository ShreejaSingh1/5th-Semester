class Solution {
    public String solveEquation(String equation) {
        String[] sides = equation.split("=");
        int[] left = evaluate(sides[0]);
        int[] right = evaluate(sides[1]);
        
        int coef = left[0] - right[0];
        int constant = right[1] - left[1];
        
        if (coef == 0 && constant == 0) return "Infinite solutions";
        if (coef == 0) return "No solution";
        return "x=" + (constant / coef);
    }

    private int[] evaluate(String exp) {
        int coef = 0, constant = 0;
        int sign = 1, num = 0;
        boolean hasNum = false;
        char[] arr = (exp + "+").toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                hasNum = true;
            } else if (c == 'x') {
                coef += sign * (hasNum ? num : 1);
                num = 0;
                hasNum = false;
            } else if (c == '+' || c == '-') {
                constant += sign * num;
                num = 0;
                hasNum = false;
                sign = (c == '+') ? 1 : -1;
            }
        }
        return new int[]{coef, constant};
    }
}
