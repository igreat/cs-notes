package exam2012;

import java.util.ArrayList;

public class RangeExcluder {
    public ArrayList<Integer> ZeroTo100NotInList(ArrayList<Integer> numbers) {
        var output = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            if (!numbers.contains(i)) output.add(i);
        }
        return output;
    }

    public static void main(String[] args) {
        var re = new RangeExcluder();
        var numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(99);
        numbers.add(101);
        var output = re.ZeroTo100NotInList(numbers);
        for (var i : output) {
            System.out.println(i);
        }
        // expected output: 0, 6, 7, 8, 9, ..., 98, 100

        int min = numbers
                .stream()
                .min(Integer::compareTo)
                .get();

        System.out.println(min);
    }
}
