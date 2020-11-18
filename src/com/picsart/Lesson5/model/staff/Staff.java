package com.picsart.Lesson5.model.staff;

import java.util.Date;

public class Staff extends Person {

    private String position;
    private Date entranceDay;
    private double salary;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getEntranceDay() {
        return entranceDay;
    }

    public void setEntranceDay(Date entranceDay) {
        this.entranceDay = entranceDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
