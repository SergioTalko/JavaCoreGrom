package lesson9;

/**
 * Created by SERGIO on 12.04.2017.
 */
public class Employee {
    String name;
    Company company;
    int monthlySalary;

    public Employee(String name, Company company, int monthlySalary) {
        this.name = name;
        this.company = company;
        this.monthlySalary = monthlySalary;
    }
}
