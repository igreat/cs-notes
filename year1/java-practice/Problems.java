import java.util.Random;
import java.util.Scanner;

public class Problems {}

class P1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a word. Enter `stop` to terminate");
        } while (!scanner.nextLine().equals("stop"));

        scanner.close();
    }
}

class P2 {
    static double getAverage(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        final int NUM_VALUES = 10;
        double[] values = new double[NUM_VALUES];
        int i = 0;
        while (i < NUM_VALUES) {
            System.out.print("Enter a number: ");
            try {
                values[i] = scanner.nextDouble();
                i++;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        scanner.close();
        System.out.println("Average: " + getAverage(values));
    }
}

class P4 {
    public static void main(String[] args) {
        Random rng = new Random();
        final int NUM_VALUES = 1_000_000;
        double min = 1;
        double max = -1;
        double sum = 0;
        for (int i = 0; i < NUM_VALUES; i++) {
            double multiplier = rng.nextBoolean() ? 1 : -1;
            double next_value = multiplier * rng.nextDouble();
            sum += next_value;
            if (next_value < min) {
                min = next_value;
            }
            if (next_value > max) {
                max = next_value;
            }
        }
        System.out.println("Min: " + min + "\t Max: " + max + "\t Average: " + sum / NUM_VALUES);
    }
}