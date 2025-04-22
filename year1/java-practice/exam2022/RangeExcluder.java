package exam2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeExcluder {
    public ArrayList<Integer> excludeFromRange0To100(List<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (!nums.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RangeExcluder re = new RangeExcluder();
        List<Integer> nums = Arrays.asList(0, 25, 50, 75, 100);
        System.out.println(re.excludeFromRange0To100(nums));
        // check not contains 0, 25, 50, 75, 100
        System.out.println(!re.excludeFromRange0To100(nums).contains(0));
        System.out.println(!re.excludeFromRange0To100(nums).contains(25));
        System.out.println(!re.excludeFromRange0To100(nums).contains(50));
        System.out.println(!re.excludeFromRange0To100(nums).contains(75));
        System.out.println(!re.excludeFromRange0To100(nums).contains(100));
    }
}
