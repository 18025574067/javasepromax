package com.itheima.d14_interface_attention;

public class Test {
    public static void main(String[] args) {
        // 接口的注意事项：

        // 1. 接口不能创建对象（接口更加彻底的抽象！）

        // 2. 一个类实现多个接口，多个接口中有同样的静态方法不冲突。

        // 3. 一个类继承了父类，同时又实现了接口，父类中和接口中有同名方法，默认用父类的。
        Cat c = new Cat();
        c.eat();

        // 4. 一个类实现了多个接口，多个接口中存在同名的默认方法，不冲突，这个类重写该方法即可。

        // 5. 一个接口继承了多个接口，是没有问题的，如果多个接口中存在规范冲突则不能多继承。
    }
}
// 5. 一个接口继承了多个接口，是没有问题的，如果多个接口中存在规范冲突则不能多继承。
interface AAA{
    void run();
//    int run();
}
interface BBB{
    void run();
}
interface CCC extends AAA, BBB{}



// 4. 一个类实现了多个接口，多个接口中存在同名的默认方法，不冲突，这个类重写该方法即可。
interface AA{
    default void go(){
        System.out.println("AA");
    }
}
interface BB{
    default void go(){
        System.out.println("BB");
    }
}

class CC implements AA, BB{

    @Override
    public void go() {
        AA.super.go();
    }
}





// 3. 一个类继承了父类，同时又实现了接口，父类中和接口中有同名方法，默认用父类的。
interface Food{
    default void eat(){
        System.out.println("接口中的吃方法~~");
    }
}
class Animal{
    public void eat(){
        System.out.println("父类动物吃~~");
    }
}
class Cat extends Animal implements Food{}

// 2. 一个类实现多个接口，多个接口中有同样的静态方法不冲突。原因是接口的静态方法不能给C 调用，只能A 调用A 的，只能B 调用B 的，
interface A{
    static void test(){
        System.out.println("A");
    }
}
interface B{
    static void test(){
        System.out.println("B");
    }
}
class C implements A, B{}