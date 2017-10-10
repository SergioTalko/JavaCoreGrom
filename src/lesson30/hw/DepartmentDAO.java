package lesson30.hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO<T> {

    private static Set<Department> departments = new HashSet<>();


    public DepartmentDAO()throws Exception {
        departments.add(new Department(DepartmentType.PROGRAMMERS,listForDepartment(DepartmentType.PROGRAMMERS)));
        departments.add(new Department(DepartmentType.DESIGNERS,listForDepartment(DepartmentType.DESIGNERS)));
        departments.add(new Department(DepartmentType.FINANCES,listForDepartment(DepartmentType.FINANCES)));
    }


    public static Set<Department> getDepartments() {
        return departments;
    }

    public static void setDepartments(Set<Department> departments) {
        DepartmentDAO.departments = departments;
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
