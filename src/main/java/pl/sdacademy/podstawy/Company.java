package pl.sdacademy.podstawy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Company {

    private final Country country;
    private final String companyName;
    private Employee[] employees;

    public Company(Country country, String companyName) {
        this.country = country;
        this.companyName = companyName;
        this.employees = new Employee[0];
    }

    public Country getCountry() {
        return country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String toString() {
        return companyName;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee... employees) {
        if (employees != null) {
            this.employees = employees;
        }
    }

    public Employee[] getRetiredEmployees(LocalDate localDate) {
        Employee[] retiredEmployees = new Employee[employees.length];
        int count = 0;
        for (Employee employee : employees) {
            if (employee.isRetired(localDate, country)) {
                retiredEmployees[count] = employee;
                count++;
            }
        }
        return Arrays.copyOf(retiredEmployees, count);

    }

    public Employee[] getRetiredEmployees() {
        return getRetiredEmployees(LocalDate.now());
    }

    public Employee[] getRetiredEmployees(String date) {
        return getRetiredEmployees(LocalDate.parse(date));
    }

    public void raise(BigDecimal payRaise){
        for ( Employee employee : employees){
            employee.raise(payRaise);
        }

    }



}
