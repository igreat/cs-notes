package exam2010;

import java.io.IOException;

public class Testing {
    public static void main(String[] args) {
        Testing t = new Testing();
        System.out.println(t.count("abracadabra", 'a')); // should print 5
        System.out.println(t.count("abracadabra", 'b')); // should print 2

        int[] counts = t.countLetters("abracadabra");
        for (int i = 0; i < counts.length; i++) {
            System.out.print((char) ('a' + i) + ":" + counts[i] + " ");
        }
        System.out.println();
    }

    public int count(String s, char p) {
        if (s.isEmpty()) return 0;
        return ((s.charAt(0) == p) ? 1 : 0)
                + count(s.substring(1), p);
    }

    public int[] countLetters(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = count(s, (char) ('a' + i));
        }
        return counts;
    }
}
