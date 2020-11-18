package com.picsart.Lesson5.model.staff;

import com.picsart.Lesson5.EmployeeBonus;

import java.util.Calendar;
import java.util.Date;

public class DeveloperSupporter extends Staff implements EmployeeBonus {

    @Override
    public void giveBonus() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getEntranceDay());
        cal.add(Calendar.YEAR, 1);
        setEntranceDay(cal.getTime());
        Date now = new Date();
        if (now.equals(getEntranceDay())) {
            System.out.println("will get 20% bonus in new year");
            setSalary(getSalary() + getSalary() * 0.2);
        }

    }
}
