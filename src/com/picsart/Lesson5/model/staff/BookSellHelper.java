package com.picsart.Lesson5.model.staff;

import com.picsart.Lesson5.EmployeeBonus;

public class BookSellHelper extends Staff implements EmployeeBonus {

    @Override
    public void giveBonus() {
        System.out.println("will get book as a bonus");
    }
}
