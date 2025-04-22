package exam2010;

public class IntParser {
    public static int parseInt(String str) throws NotADigit, TooManyDigits {
        int power = 1;
        int result = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            if ('0' > c || c > '9') {
                throw new NotADigit();
            }
            result += toDigit(c) * power;
            power *= 10;
        }
        if (str.length() > 6) throw new TooManyDigits();
        return result;
    }

    private static int toDigit(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        try {
            System.out.println(parseInt("123"));
            System.out.println(parseInt("123456"));
            System.out.println(parseInt("1234567"));
        } catch (NotADigit | TooManyDigits e) {
            System.out.println(e.getMessage());
        }
    }
}

class NotADigit extends Exception {
    public NotADigit() {
        super("Not a digit");
    }
}

class TooManyDigits extends Exception {
    public TooManyDigits() {
        super("Too many digits");
    }
}