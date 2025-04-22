import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class UsefulSnippets {

    static void IOSnippets() {
        // writing
        System.out.println("Writing");
        try {
            File file = new File("test.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("123\n");
            bufferedWriter.write("456\n");
            bufferedWriter.write("gg well played\n");
            bufferedWriter.write("1 2 3\n");
            bufferedWriter.write("4 5 6\n");
            bufferedWriter.close();
        } catch (IOException e) {
            // handle exception if needed
        }

        // reading
        System.out.println("\nReading");
        try {
            File file = new File("test.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception if needed
        }

        // using NIO to read and parse integers
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("\nReading with NIO");
        try {
            Stream<String> lines = Files.lines(Path.of("test.txt"));
            lines.forEach(line -> {
                try {
                    numbers.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    // handle exception if needed
                }
            });
//            for (String line : (Iterable<String>) lines::iterator) {
//                try {
//                    numbers.add(Integer.parseInt(line));
//                } catch (NumberFormatException e) {
//                    // handle exception if needed
//                }
//            }
            lines.close();
        } catch (IOException e) {
            // handle exception if needed
        }
        System.out.println(numbers);

        // reading integers through a Scanner
        System.out.println("\nReading integers through a Scanner");
        try {
            File file = new File("test.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Scanner scanner = new Scanner(bufferedReader);
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
        } catch (
                IOException e) {
            // handle exception if needed
        }

        // equivalent to the above code but without a Scanner and reads lines
        System.out.println("\nReading integers without a Scanner");
        try {
            File file = new File("test.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    System.out.println(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    // handle exception if needed
                }
            }
        } catch (
                IOException e) {
            // handle exception if needed
        }
    }

    static void hashmapSnippets() {
        // test hashmap
        System.out.println("\nTesting HashMap");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 69);
        map.put(2, 420);
        // use stream api
        int sum = map
                .values()
                .stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }

    static void sortingSnippets() {
        // test arraylist
        System.out.println("\nTesting ArrayList");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-1);
        list.add(0);
        // sort in ascending order
//       or list.sort(Comparator.naturalOrder());
        list.sort(Integer::compareTo);
        // or Collections.sort(list);
        // or list.sort((a, b) -> a - b);
        System.out.println(list);

        // test array
        System.out.println("\nTesting Array");
        int[] arr = {1, 2, 3, -1, 0};
        // sort in ascending order
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void randomSnippets() {
        // this has to be forced to a float because default literals are doubles
        float d = 1.234f;
        System.out.println("float: " + d);

        // primitive values can get auto-boxed auto-unboxed
        Integer i = 69; // auto-boxing
        int j = i; // auto-unboxing

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // auto-boxing
        list.add(2); // auto-boxing
        int k = list.get(1); // auto-unboxing

        // initialize an array of Integers
        Integer[] arr = new Integer[5];
        // q: are the elements initalized to null or 0?
        System.out.println(arr[0]);
        // a: null
        // it would be 0 if it was an array of ints
    }

    public static void main(String[] args) {
        // print command line arguments
//        System.out.println("Command line arguments:");
//        for (String arg : args) {
//            System.out.println(arg);
//        }

//        IOSnippets();
        hashmapSnippets();
//        sortingSnippets();
//        randomSnippets();
    }
}
