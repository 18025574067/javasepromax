package com.itheima.d1_junit;

import org.junit.*;

/**
    测试类
 */
public class TestUserService {

    // 修饰实例方法的。
    @Before
    public void before(){
        System.out.println("========befort方法执行一次=======");
    }

    @After
    public void after(){
        System.out.println("=============after方法执行一次================");
    }

    // 修饰静态方法的
    @BeforeClass
    public static void beforeClass(){
        System.out.println("========befortClass方法执行一次=======");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("=============afterClass方法执行一次================");
    }


    /**
        测试方法
        注意点：
            1. 必须是无参数，公开的，无返回值的方法
            2. 测试方法必须使用@Test注解标记。
     */
    @Test
    public void testUserService(){
        UserService userService = new UserService();
        String rs = userService.loginName("admin", "123456");

        // 进行预期结果的正确性测试：断言
        Assert.assertEquals("您的功能业务可能出现问题", "登录成功", rs);
    }

    @Test
    public void testSelectNames(){
        UserService userService = new UserService();
        userService.selectNames();
    }
}
