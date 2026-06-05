import java.util.Scanner;

class Solution {
    public static String intToRoman(int num) {
        // Roman numeral symbols with their values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Iterate over all possible values
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {  // Subtract the highest possible value
                num -= values[i];
                roman.append(symbols[i]); // Append the corresponding Roman numeral
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close(); // Close Scanner

        System.out.println(intToRoman(num));
    }
}
