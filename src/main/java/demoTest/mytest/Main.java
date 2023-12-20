package demoTest.mytest;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        System.out.println("mySet = " + mySet);

        ProjectVo projectVo = new ProjectVo();
        System.out.println("projectVo = " + projectVo);
    }

}
