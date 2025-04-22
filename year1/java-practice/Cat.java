import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Cat extends Mammal {
    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void giveBirth() {
        System.out.println("Kittens");
        for (char c : this.name.toCharArray()) {
            // check if it is alphabetic lower case
            if (c >= 'a' && c <= 'z') {
                System.out.println(c);
            }
        }
        takeADump();
    }

    public final void printName() throws Exception {
        System.out.println(this.name);
        throw new Exception("This is an exception");
    }

    public <T, V extends T> boolean isIn(T x, V[] arr) {
        for (V y : arr) {
            if (x.equals(y)) {
                return true;
            }
        }
        return false;
    }
}
