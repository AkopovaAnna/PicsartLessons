package com.picsart.Lesson3.oop.company.service;

import com.picsart.Lesson3.oop.company.model.Company;

import java.util.NoSuchElementException;

import static com.picsart.Lesson3.oop.utils.Validator.isEmpty;

public class CompanyService {


    private static final int MAX_SIZE = 100;
    public static int currentCount;
    private Company[] companies;

    public CompanyService() {
        companies = new Company[MAX_SIZE];
    }

    private boolean isValidCompany(Company company) {
        if (isEmpty(company.getCompanyName())) {
            return false;
        }

        return true;
    }


    public void addCompany(Company company) {
        if (currentCount < companies.length && isValidCompany(company)) {
            this.companies[currentCount] = company;
            currentCount++;
        }
    }

    public Company getCompanyByName(String companyName) {
        for (int i = 0; i < currentCount; i++) {
            if (companies[i].getCompanyName().equalsIgnoreCase(companyName)) {
                return companies[i];
            }
        }
        throw new NoSuchElementException("Company with this name was not found");
    }
}
