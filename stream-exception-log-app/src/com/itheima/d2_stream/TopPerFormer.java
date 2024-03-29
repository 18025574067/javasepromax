package com.itheima.d2_stream;

public class TopPerFormer {
    private String name;
    private double money; // 月收入

    public TopPerFormer() {
    }

    public TopPerFormer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TopPerFormer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
