package exam2011;

import java.util.ArrayList;
import java.util.Arrays;

public class Divisibles {
    public static int[] getDivisible(int[] numbers, int divisor) {
        ArrayList<Integer> divisible = new ArrayList<>();

        for (int n : numbers) {
            if (n % divisor == 0) {
                divisible.add(n);
            }
        }

        int[] result = new int[divisible.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = divisible.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int divisor = 3;
        int[] divisible = getDivisible(numbers, divisor);
        System.out.println(Arrays.toString(divisible));
    }
}
