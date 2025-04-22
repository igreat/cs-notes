package exam2023.problem4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IntegerBuffer {
    private ArrayList<Integer> integers;
    private int currentIndex;

    public IntegerBuffer() {
        this.integers = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void readFile(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                try {
                    integers.add(Integer.parseInt(line));
                } catch (Exception e) {
                    // line will simply be skipped as intended
                }
            });
        }
    }

    public void readFile(String filePath) throws IOException {
        readFile(Path.of(filePath));
    }

    public int getInteger() throws NoIntAvailableException {
        if (currentIndex >= integers.size()) {
            throw new NoIntAvailableException();
        }
        return integers.get(currentIndex++);
    }

    public void restart() throws NoIntAvailableException {
        currentIndex = 0;
        if (integers.isEmpty()) {
            throw new NoIntAvailableException("Buffer is empty");
        }
    }

    public static void main(String[] args) {
        IntegerBuffer buffer = new IntegerBuffer();
        try {
            buffer.readFile("numbers.txt");
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
            buffer.restart();
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
            System.out.println(buffer.getInteger());
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (NoIntAvailableException e) {
            System.out.println("No more integers available");
        }
    }
}
