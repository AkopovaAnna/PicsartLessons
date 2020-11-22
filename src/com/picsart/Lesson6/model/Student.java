package com.picsart.Lesson6.model;

public class Student {

    private String firstName;
    private String lastName;
    private Integer year;
    private char gender;
    private Double mark;


    public Student() {

    }

    public Student(String firstName, String lastName, int year, char gender, double mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.gender = gender;
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", gender=" + gender +
                ", mark=" + mark +
                '}';
    }
}
