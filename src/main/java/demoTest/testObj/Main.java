package demoTest.testObj;

import cn.hutool.core.bean.BeanUtil;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("John");
        GameUser gameUser = new GameUser();
        BeanUtil.copyProperties(user,gameUser);
        gameUser.setGender("male");
        hello(gameUser);
    }

    public static void hello(User user){
        System.out.println("user = " + user);
    }
}
