package demoTest.listTest;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> taskDetail = new ArrayList<>();
        taskDetail.add("Tom");
        taskDetail.add("John");
        taskDetail.add("Jenny");
        taskDetail.add("Lucy");
        taskDetail.add("Han");
        System.out.println("taskDetail1 = " + taskDetail);
        sub(taskDetail);
        System.out.println("taskDetail3 = " + taskDetail);
    }

    public static void sub(List<String> taskDetail) {
        taskDetail = taskDetail.subList(2, taskDetail.size());
        System.out.println("taskDetail2 = " + taskDetail);
    }
}
