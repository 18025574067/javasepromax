package com.itheima.d4_reflect_field;

import org.junit.Test;

import java.lang.reflect.Field;

/**
    反射的第一步是先得到Class类对象。

    1.Field getField(String name);
        根据成员变量名获得对应Field对象，只能获得public修饰
    2.Field getDeclaredField(String name);
        根据成员变量名获得对应Field对象，只要申明了就可以得到
    3.Field[] getFields();
        获得所有的成员变量对应的Field对象，只能获得public的
    4.Field[] getDeclaredField();
        获得所有的成员变量对应的Field对象，只要申明了就可以得到
    小结：
        获取全部成员变量：getDeclaredFields
        获取某个成员变量：getDeclaredField
*/
public class FieldDemo01{
    /**
     * 1.获取全部的成员变量。
     * Filed[] getDeclaredFields();
     * 获得所有的成员变量对应的Field对象，只要申明就可以拿到。
     */
    @Test
    public void getDeclaredFields(){
        // a. 定位Class对象
        Class c = Student.class;
        // b. 定位全部成员变量
        Field[] fields = c.getDeclaredFields();
        // c. 遍历一下
        for (Field field : fields) {
            System.out.println(field.getName() + "===>" + field.getType());
        }
    }

    /**
        2.获取某个成员变量对象, Field getDeclaredField(String name).
     */
    @Test
    public void getDeclaredField() throws Exception {
        // a. 定位Class对象
        Class c = Student.class;
        // b. 根据名称定位某个成员变量
        Field field = c.getDeclaredField("age");
        System.out.println(field.getName() + "===>" + field.getType());
    }
}
