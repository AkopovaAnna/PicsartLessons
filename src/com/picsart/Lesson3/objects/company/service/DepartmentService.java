package com.picsart.Lesson3.objects.company.service;

import com.picsart.Lesson3.objects.company.model.Department;
import com.picsart.Lesson3.objects.company.model.Employee;

import java.util.NoSuchElementException;

import static com.picsart.Lesson3.objects.utils.Validator.isEmpty;

public class DepartmentService {

    private static final int MAX_SIZE = 50;
    private static int currentCount;
    private Department[] departments;

    public DepartmentService() {
        departments = new Department[MAX_SIZE];
    }

    private boolean isValidDepartment(Department department) {
        return !isEmpty(department.getDepartmentName());

    }

    public void assignManagerToDep(Department department, Employee manager) {
        if(manager.getPosition().equalsIgnoreCase("manager")){
            department.setManager(manager);
        } else {
            throw new RuntimeException("Provided manager is not fit to department");
        }
    }

    public Department[] addDepartment(Department department) {
        if (currentCount < departments.length && isValidDepartment(department)) {
            this.departments[currentCount] = department;
            currentCount++;
            return departments;

        } else {
            throw new RuntimeException("invalid provided data");
        }
    }

    public Department getDepByDepName(String depName) {
        for (int i = 0; i < currentCount; i++) {
            if (departments[i].getDepartmentName().equalsIgnoreCase(depName)) {
                return departments[i];
            }
        }
        throw new NoSuchElementException("Department with this department name was not found");
    }

}
