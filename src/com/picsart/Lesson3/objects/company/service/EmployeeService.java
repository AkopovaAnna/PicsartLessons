package com.picsart.Lesson3.objects.company.service;

import com.picsart.Lesson3.objects.company.model.Employee;

import java.util.NoSuchElementException;

import static com.picsart.Lesson3.objects.utils.Validator.isEmpty;

public class EmployeeService {

    private Employee[] employees;

    public static final int MAX_SIZE_OF_EMPLOYEE = 100;
    private static final int SSN_MAX_LENGTH = 11;
    public static int currentCount;

    public EmployeeService() {
        this.employees = new Employee[MAX_SIZE_OF_EMPLOYEE];
    }


    public boolean isValidEmployee(Employee employee) {

        if (isEmpty(employee.getSsn())) {
            System.out.println("Ssn can not be null or empty");
            return false;
        }

        if (employee.getSsn().length() != SSN_MAX_LENGTH) {
            System.out.println("Ssn length can not be " + employee.getSsn().length());
            return false;
        }

        if (isEmpty(employee.getEmail())) {
            System.out.println("email can not be null or empty");
            return false;
        }

        if (employee.getDepartmentId() == 0) {
            System.out.println("Department can not be  empty");
            return false;
        }
        return true;
    }


    public Employee[] addEmployee(Employee employee) {
        if (currentCount < employees.length && isValidEmployee(employee)) {
            this.employees[currentCount] = employee;
            currentCount++;
            return employees;
        } else {
            throw new RuntimeException("invalid provided data");
        }
    }


    public Employee getEmployeeByEmail(String email) {
        for (int i = 0; i < currentCount; i++) {
            if (employees[i].getEmail().equalsIgnoreCase(email)) {
                return employees[i];
            }
        }
        throw new NoSuchElementException("Employee was not found with this email");
    }

    public Employee[] getEmployees() {
        Employee[] existingEmployees = new Employee[currentCount];
        for (int i = 0; i < currentCount; i++) {
            existingEmployees[i] = this.employees[i];
        }
        return existingEmployees;
    }

}
