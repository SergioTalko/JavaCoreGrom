package lesson30.hw;

import lesson30.hw.DAO.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private DepartmentType type;
    private ArrayList<Employee> employees;


    public Department(DepartmentType type, ArrayList<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }

    /*public void find() {

        for (Employee em : EmployeeDAO.getEmployees()) {
            if (em.getDepartment().equals(type)) {
                employees.add(em);
            }
        }
    }*/


    public DepartmentType getType() {
        return type;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }


}
