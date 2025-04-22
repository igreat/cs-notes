package exam2012;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                list.add("Hello");
            }
            lists.add(list);
        }

        for (ArrayList<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("f(" + i + ") -> " + f(i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("f_iter(" + i + ") -> " + f_iter(i));
        }
    }

    // essentially returns 2^n on non-negative integers
    public static int f(int n) {
        if (n < 1) {
            return 1;
        } else {
            return f(n - 1) + f(n - 1);
        }
    }

    public static int f_iter(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        return result;
    }
}
