package practice2022;

import java.util.ArrayList;

public class Sequence {
    private int start;
    private int count;
    private int increment;

    public Sequence(int start, int count, int increment) throws IllegalArgumentException {
        if (increment <= 0 || count < 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.start = start;
        this.count = count;
        this.increment = increment;
    }

    public int getStart() {
        return this.start;
    }

    public int getCount() {
        return this.count;
    }

    public boolean contains(int n) {
        int upperBound = start + increment * (count - 1);
        boolean withinRange = n >= start && n <= upperBound;
        boolean divisible = (n - start) % increment == 0;
        return withinRange && divisible;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(start + i * increment);
        }
        return values;
    }

    public static void main(String[] args) {
        // test practice2022.Sequence
        try {
            Sequence s = new Sequence(1, 5, 2);
            System.out.println(s.getStart() + " == 1");
            System.out.println(s.getCount() + " == 5");
            System.out.println(1 + " is" + (s.contains(1) ? "" : " not") + " in " + s.getValues());
            System.out.println(3 + " is" + (s.contains(3) ? "" : " not") + " in " + s.getValues());
            System.out.println(5 + " is" + (s.contains(5) ? "" : " not") + " in " + s.getValues());
            System.out.println(7 + " is" + (s.contains(7) ? "" : " not") + " in " + s.getValues());
            System.out.println(9 + " is" + (s.contains(9) ? "" : " not") + " in " + s.getValues());
            System.out.println(0 + " is" + (s.contains(0) ? "" : " not") + " in " + s.getValues());
            System.out.println(2 + " is" + (s.contains(2) ? "" : " not") + " in " + s.getValues());
            System.out.println(4 + " is" + (s.contains(4) ? "" : " not") + " in " + s.getValues());
            System.out.println(6 + " is" + (s.contains(6) ? "" : " not") + " in " + s.getValues());
            System.out.println(8 + " is" + (s.contains(8) ? "" : " not") + " in " + s.getValues());
            System.out.println(10 + " is" + (s.contains(10) ? "" : " not") + " in " + s.getValues());
            System.out.println(11 + " is" + (s.contains(11) ? "" : " not") + " in " + s.getValues());
            System.out.println(s.getValues() + " == [1, 3, 5, 7, 9]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
