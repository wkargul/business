package pl.sdacademy.podstawy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Country poland = new Country(65, "Poland");
        Country germany = new Country(67, "Germany");

        for (Country country : new Country[]{poland, germany}) {
            System.out.println(country);
        }

        Company terravita = new Company(poland, "Terravita");
        Company volkswagen = new Company(germany, "Volkswagen");

        Employee employee1 = new Employee("Hans", "M\u00fcller", LocalDate.of(1956, 6, 16));
        Employee employee2 = new Employee("Helga", "Schweinsteiger", LocalDate.of(1999, 7, 24));
        Employee employee5 = new Employee("Helmut", "Stern", LocalDate.of(1950, 7, 24));

        Employee employee3 = new Employee("Jan", "Kowalski", LocalDate.of(1985, 1, 21));
        Employee employee4 = new Employee("Anna", "Nowak", LocalDate.of(1966, 4, 28));

        volkswagen.setEmployees(employee1, employee2, employee5);
        terravita.setEmployees(employee3, employee4);

        for (Company company : new Company[]{terravita, volkswagen}) {
            for (Employee employee : company.getEmployees()) {
                System.out.printf("Kraj: %s, Nazwa firmy: %s, Pracownik: %s\n", company.getCountry(), company, employee);
            }
        }

        for (Employee employee : volkswagen.getRetiredEmployees(LocalDate.of(2040, 4, 4))) {
            System.out.println(employee.toString());
        }

        for (Employee employee : volkswagen.getRetiredEmployees()){
            System.out.println("W dniu dzisiejszym na emeryturze może być: " + employee.toString());
        }

        for (Company company : new Company[]{terravita, volkswagen}) {
            for (Employee employee : company.getEmployees()) {
                System.out.printf("Wynagrodzenie %s wynosi %s\n", employee.getFirstName(),employee.getSalary());
            }
        }

        for (Company company : new Company[]{terravita, volkswagen}) {
            company.raise(new BigDecimal(900));
        }

        for (Company company : new Company[]{terravita, volkswagen}) {
            company.raise(new BigDecimal("100.5"));
        }

        for (Company company : new Company[]{terravita, volkswagen}) {
            for (Employee employee : company.getEmployees()) {
                System.out.printf("Wynagrodzenie %s po podwyżkach wynosi %s\n", employee.getFirstName(),employee.getSalary());
            }
        }



    }
}
