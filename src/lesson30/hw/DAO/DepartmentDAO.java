package lesson30.hw.DAO;

import lesson30.hw.Department;
import lesson30.hw.DepartmentType;
import lesson30.hw.Employee;

import java.util.ArrayList;

public class DepartmentDAO<T> {

    private static ArrayList<Department> departments = new ArrayList<>();
    private EmployeeDAO employeeDAO;


    public DepartmentDAO()throws Exception {
        departments.add(new Department(DepartmentType.PROGRAMMERS,listForDepartment(DepartmentType.PROGRAMMERS)));
        departments.add(new Department(DepartmentType.DESIGNERS,listForDepartment(DepartmentType.DESIGNERS)));
        departments.add(new Department(DepartmentType.FINANCES,listForDepartment(DepartmentType.FINANCES)));
    }


    public static ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    private ArrayList<Employee> listForDepartment(DepartmentType type) throws Exception {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getDepartment().equals(type)) {
                result.add(employee);
            }
        }
        return result;
    }
}
