class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] parts1 = num1.split("\\+");
        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1].replace("i", ""));
        String[] parts2 = num2.split("\\+");
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1].replace("i", ""));
        int real = a * c - b * d;
        int imag = a * d + b * c;
        return real + "+" + imag + "i";
    }
}
