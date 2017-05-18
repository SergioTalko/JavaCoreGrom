package lesson10.abstractbigexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class EmployeeController {
    private Employee[] employees = new Employee[100];


    void paySalaryToEmployess() {
        for (Employee employee : employees) {
            employee.paySalary();
            System.out.println("Salary was paid successfully to " + employee.getName() + "employee");
        }
    }
}
