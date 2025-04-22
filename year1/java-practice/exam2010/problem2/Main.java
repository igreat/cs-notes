package exam2010.problem2;

public class Main {
    public static void main(String[] args) {
        IntPair pair = new IntPair(3, 5);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        Pair<String, Integer> pair2 = new Pair<>("hello", 42);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());

        IntPair[] pairs = {
                new IntPair(1, 2),
                new IntPair(4, 7),
                new IntPair(9, 4)
        };
        IntPair maxMin = maxMinPair(pairs);
        System.out.println("(" + maxMin.getFirst() + ", " + maxMin.getSecond() + ")");
    }

    public static IntPair maxMinPair(IntPair[] pairs) {
        if (pairs.length == 0) return null;

        int maxFirst  = pairs[0].getFirst();
        int minSecond = pairs[0].getSecond();

        for (IntPair pair : pairs) {
            if (pair.getFirst() > maxFirst) {
                maxFirst = pair.getFirst();
            }
            if (pair.getSecond() < minSecond) {
                minSecond = pair.getSecond();
            }
        }
        return new IntPair(maxFirst, minSecond);
    }
}
