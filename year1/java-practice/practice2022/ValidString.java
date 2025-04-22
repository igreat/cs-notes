package practice2022;

public class ValidString {
    public static void main(String[] args) {
        System.out.println("TESTING isValidV1");
        // test isValid1
        System.out.println(isValidV1("hello,world") + "==true");
        System.out.println(isValidV1("hello,world,") + "==false");
        System.out.println(isValidV1("hello,World") + "==false");
        System.out.println(isValidV1("hello,world!") + "==false");
        System.out.println(isValidV1("hello, world") + "==false");
        System.out.println(isValidV1("hello,world,yes") + "==false");

        System.out.println("TESTING isValidV2");
        // test isValid2
        System.out.println(isValidV2("hello,world") + "==true");
        System.out.println(isValidV2("hello,world,") + "==false");
        System.out.println(isValidV2("hello,World") + "==false");
        System.out.println(isValidV2("hello,world!") + "==false");
        System.out.println(isValidV2("hello, world") + "==false");
        System.out.println(isValidV2("hello,world,yes") + "==false");
    }

    public static boolean isValidV1(String s) {
        return s.matches("^[a-z]+,[a-z]+$");
    }

    public static boolean isValidV2(String s) {
        // check non-empty string
        if (s.isEmpty()) {
            return false;
        }

        // checking only one comma and lowercase alphabetic characters
        int commaCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ',') {
                if (commaCount > 0) {
                    return false;
                }
                commaCount++;
            } else if (!(c >= 'a' && c <= 'z')) {
                return false;
            }
        }

        return commaCount == 1;
    }
}
