package lesson30.hw;

import lesson30.hw.DAO.EmployeeDAO;
import lesson30.hw.DAO.ProjectDAO;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static ProjectDAO projectDAO;
    private static EmployeeDAO employeeDAO;


    public ArrayList<Employee> employeesByProject(Project project) throws Exception {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getProjects().contains(project)) {
                result.add(employee);
            }

        }
        return result;
    }


}
