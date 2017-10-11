package lesson30.hw;

import java.util.ArrayList;

public class Controller {


    public ArrayList<Employee> employeesByProject(Project project) throws Exception {
        return EmployeeDAO.employeesByProject(project);
    }


    public ArrayList<Project> projectsByEMployee(Employee employee) throws Exception {

        return EmployeeDAO.projectsByEMployee(employee);
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType type) throws Exception {
        return EmployeeDAO.employeesByDepartmentWithoutProject(type);

    }


    public ArrayList<Employee> employeesWithoutProject() throws Exception {

        return EmployeeDAO.employeesWithoutProject();

    }

    public ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {

        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {

        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public ArrayList<Employee> employeesByProjectEmployee(Employee employee) {

        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {

        return ProjectDAO.projectsByCustomer(customer);
    }

    public ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {


        return EmployeeDAO.employeesByCustomerProjects(customer);


    }


}
