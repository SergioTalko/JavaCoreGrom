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

        if (employee == null) throw new Exception("Input data is null");
        ArrayList<Employee> teamLeads = new ArrayList<>();


        for (Project project : employee.getProjects()) {
            for (Employee employee1 : EmployeeDAO.getEmployees()) {
                if (employee1 != null && employee1.getProjects().contains(project) && employee1.getPosition() == Position.TEAM_LEAD) {
                    teamLeads.add(employee1);
                }
            }
        }

        return teamLeads;
    }

    public ArrayList<Employee> employeesByProjectEmployee(Employee employee) {

        ArrayList<Employee> result = new ArrayList<>();

        for (Project project : employee.getProjects()) {
            for (Employee employee1 : EmployeeDAO.getEmployees()) {
                if (project != null && employee1 != null && employee1.getProjects().contains(project)) {
                    result.add(employee1);
                }
            }
        }
        result.remove(employee);

        return result;
    }

    public ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {

        if (customer == null) throw new Exception("Input data is null");

        ArrayList<Project> result = new ArrayList<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (project != null && project.getCustomer().equals(customer)) {
                result.add(project);
            }
        }
        return result;
    }

    public ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {


        if (customer == null) throw new Exception("Input data is null");

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : EmployeeDAO.getEmployees()) {
            for (Project project : employee.getProjects())
                if (employee != null && project != null && project.getCustomer().equals(customer)) {
                    result.add(employee);
                }
        }
        return result;


    }


}
