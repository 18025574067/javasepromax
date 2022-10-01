package com.itheima.d3_reflect_constructor;

public class Student {
    private String name;
    private int age;

    private Student() { System.out.println("无参数构造执行！");}

    private Student(String name, int age) {
        System.out.println("有参数构造器执行");
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

