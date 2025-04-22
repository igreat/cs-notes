public abstract class Animal {
    int age;
    String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void takeADump() {
        System.out.println("I'm taking a dump");
    }

    public abstract void makeSound();
}
