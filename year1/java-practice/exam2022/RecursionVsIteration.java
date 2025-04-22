package exam2022;

public class RecursionVsIteration {
    public static int fRec(int n) {
        if (n < 1) {
            return 1;
        } else {
            return fRec(n - 1) + fRec(n - 1);
        }
    }

    public static int fIter(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fRec(0) + " == 1");
        System.out.println(fIter(0) + " == 1");
        System.out.println(fRec(1) + " == 2");
        System.out.println(fIter(1) + " == 2");
        System.out.println(fRec(2) + " == 4");
        System.out.println(fIter(2) + " == 4");
        System.out.println(fRec(3) + " == 8");
        System.out.println(fIter(3) + " == 8");
        System.out.println(fRec(4) + " == 16");
        System.out.println(fIter(4) + " == 16");
        System.out.println(fRec(5) + " == 32");
        System.out.println(fIter(5) + " == 32");
    }
}
