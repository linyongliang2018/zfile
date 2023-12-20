package demoTest.testObj;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println("Before change, list = " + list);
        change(list);
        System.out.println("After change, list = " + list);
    }

    public static void change(List<Integer> list) {
        list.add(20);
//        list = new ArrayList<>();
    }
}
