package exam2011;

public class RecursivePrint {
    public static void g(int i, int j) {
        if (i < j) {
            System.out.print(i + " ");
            i++;
            g(i, j);
        }
    }

    public static void main(String[] args) {
        System.out.print("g(5, 5) -> ");
        g(5, 5);
        System.out.println();
        System.out.print("g(4, 5) -> ");
        g(4, 5);
        System.out.println();
        System.out.print("g(3, 5) -> ");
        g(3, 5);
        System.out.println();
        System.out.print("g(2, 5) -> ");
        g(2, 5);
        System.out.println();
        System.out.print("g(1, 5) -> ");
        g(1, 5);
        System.out.println();
        System.out.print("g(0, 6) -> ");
        g(0, 6);
        System.out.println();
    }
}
