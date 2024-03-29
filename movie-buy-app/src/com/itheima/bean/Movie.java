package com.itheima.bean;

import java.util.Date;

public class Movie {
    private String name;
    private String actor;
    private double score;
    private double price;
    private double time;
    private int number; // 余票;
    private Date startTime; // 放映时间。

    public Movie() {
    }

    public Movie(String name, String actor,  double price, double time, int number, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.price = price;
        this.time = time;
        this.number = number;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
