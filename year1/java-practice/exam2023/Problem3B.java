package exam2023;

public class Problem3B {
    public boolean isValid(String s) {
        return s.matches("^[a-zA-Z]{2,},[a-zA-Z]{2,}$");
    }

    public static void main(String[] args) {
        Problem3B p = new Problem3B();
        System.out.println(p.isValid("hello,world") + "==true");
        System.out.println(p.isValid("hello,world,") + "==false");
        System.out.println(p.isValid("hello,World") + "==true");
        System.out.println(p.isValid("hello,world!") + "==false");
        System.out.println(p.isValid("hello, world") + "==false");
        System.out.println(p.isValid("hello,world,yes") + "==false");
        System.out.println(p.isValid("hello,world,") + "==false");
        System.out.println(p.isValid("h,w") + "==false");
    }
}
