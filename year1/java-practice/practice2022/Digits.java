package practice2022;

import java.util.Arrays;

public class Digits {
    public static void main(String[] args) {
        // test getDigits
        Digits d = new Digits();
        System.out.println(Arrays.toString(d.getDigits(123)) + " == [1, 2, 3]");
        System.out.println(Arrays.toString(d.getDigits(123456789)) + " == [1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println(Arrays.toString(d.getDigits(1)) + " == [1]");

        // test sameDigits
        System.out.println(d.sameDigits(123, 321) + " == true");
        System.out.println(d.sameDigits(123, 123) + " == true");
        System.out.println(d.sameDigits(123, 132) + " == true");
        System.out.println(d.sameDigits(123, 12) + " == false");
        System.out.println(d.sameDigits(123, 3210) + " == false");
    }

    public int[] getDigits(int n) {
        int[] digits = new int[(int) Math.floor(Math.log10(n)) + 1];
        for (int j = digits.length - 1; j >= 0; j--) {
            digits[j] = n % 10;
            n /= 10;
        }
        return digits;
    }

    public boolean sameDigits(int x, int y) {
        int[] digitsX = getDigits(x);
        int[] digitsY = getDigits(y);
        if (digitsX.length != digitsY.length) {
            return false;
        }
        Arrays.sort(digitsX);
        Arrays.sort(digitsY);

        for (int i = 0; i < digitsX.length; i++) {
            if (digitsX[i] != digitsY[i]) {
                return false;
            }
        }
        return true;
    }
}
