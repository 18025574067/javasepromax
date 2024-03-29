package com.itheima.bean;

/**
    用户类（商家和客户的父类）
 */
public class User {
    private String loginName; // 登录名;
    private String userName; // 真实姓名;
    private char sex;
    private String phone;
    private double money;
    private String passWord;

    public User() {
    }

    public User(String loginName, String userName, char sex, String phone, double money, String passWord) {
        this.loginName = loginName;
        this.userName = userName;
        this.sex = sex;
        this.phone = phone;
        this.money = money;
        this.passWord = passWord;

    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
