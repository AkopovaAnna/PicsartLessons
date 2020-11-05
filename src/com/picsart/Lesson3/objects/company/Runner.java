package com.picsart.Lesson3.objects.company;

import com.picsart.Lesson3.objects.company.model.Company;
import com.picsart.Lesson3.objects.company.model.Department;
import com.picsart.Lesson3.objects.company.model.Employee;
import com.picsart.Lesson3.objects.company.service.CompanyService;
import com.picsart.Lesson3.objects.company.service.DepartmentService;
import com.picsart.Lesson3.objects.company.service.EmployeeService;

public class Runner {

    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        DepartmentService departmentService = new DepartmentService();
        EmployeeService employeeService = new EmployeeService();

        Company piscart = new Company();
        piscart.setCompanyId(1);
        piscart.setCompanyName("Picsart");

        companyService.addCompany(piscart);

        Company facebook = new Company();
        facebook.setCompanyId(2);
        facebook.setCompanyName("Facebook");

        companyService.addCompany(facebook);

        Department picsartLab = new Department();
        picsartLab.setDepartmentId(1);
        picsartLab.setCompanyId(1);
        picsartLab.setDepartmentName("PicsartLab");

        departmentService.addDepartment(picsartLab);


        Department mobile = new Department();
        mobile.setDepartmentId(2);
        mobile.setCompanyId(2);
        mobile.setDepartmentName("Mobile");

        departmentService.addDepartment(mobile);

        Department account = new Department();
        account.setDepartmentId(3);
        account.setCompanyId(2);
        account.setDepartmentName("Account");

        departmentService.addDepartment(account);

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setSsn("23467776562");
        employee1.setFirstName("Hayk");
        employee1.setLastName("Avdalyan");
        employee1.setAddress("Halabyan");
        employee1.setPosition("Lead Engineer");
        employee1.setEmail("employee1@picsart.com");
        employee1.setDepartmentId(1);

        employeeService.addEmployee(employee1);


        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setSsn("23467776533");
        employee2.setFirstName("Anna");
        employee2.setLastName("Akopova");
        employee2.setAddress("Halabyan");
        employee2.setPosition("Java Intern");
        employee2.setEmail("employee2@picsart.com");
        employee2.setDepartmentId(2);

        employeeService.addEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setEmployeeId(3);
        employee3.setSsn("23467776162");
        employee3.setFirstName("Ani");
        employee3.setLastName("Sargsyan");
        employee3.setAddress("Halabyan");
        employee3.setPosition("Manager");
        employee3.setEmail("employee3@picsart.com");
        employee3.setDepartmentId(1);

        employeeService.addEmployee(employee3);
        departmentService.assignManagerToDep(picsartLab, employee3);



        for (Employee emp :
                employeeService.getEmployees()) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " +
                    emp.getPosition());
        }


    }
}
