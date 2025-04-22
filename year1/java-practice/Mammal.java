public abstract class Mammal extends Animal {
    public Mammal(int age, String name) {
        super(age, name);
    }

    public <T extends Comparable<T>> T max(T t1, T t2) {
        return t1.compareTo(t2) > 0 ? t1 : t2;
    }

    public abstract void giveBirth();
}
