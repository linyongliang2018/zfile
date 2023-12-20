package demoTest.testObj;

public class Test {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Before change, num = " + num);
        change(num);
        System.out.println("After change, num = " + num);
    }

    public static void change(int x) {
        x = 20;
    }
}
