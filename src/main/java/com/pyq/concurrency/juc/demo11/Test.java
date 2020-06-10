package com.pyq.concurrency.juc.demo11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选：
 * 1、ID 必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);

        List<User> userList = Arrays.asList(u1, u2, u3, u4, u5);
        System.out.println("userList.stream().filter(item -> item.getId()%2 == 0)\n                .filter(item -> item.getAge() > 23)\n                .map(item -> item.getName().toUpperCase()).sorted().findFirst().get() = " + userList.stream().filter(item -> item.getId() % 2 == 0)
                .filter(item -> item.getAge() > 23)
                .map(item -> item.getName().toUpperCase()).sorted(Comparator.reverseOrder()).findFirst().get());;

    }
}
class User{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
