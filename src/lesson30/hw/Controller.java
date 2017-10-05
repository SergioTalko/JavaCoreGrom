package lesson30.hw;

import java.util.ArrayList;

public class Controller {


    public ArrayList<Employee> employeesByProject(Project project) throws Exception {
        if (project == null) throw new Exception("Input data is null");
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee != null && employee.getProjects().contains(project)) {
                result.add(employee);
            }

        }
        return result;
    }


    public ArrayList<Project> projectsByEMployee(Employee employee) throws Exception {

        if (employee == null) throw new Exception("Input data is null");
        for (Employee employee1 : EmployeeDAO.getEmployees()) {
            if (employee1 != null && employee1.equals(employee)) {
                return employee1.getProjects();
            }
        }

        throw new Exception("Cant find in DB employee with name " + employee.getFirstName());
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType type) throws Exception {
        if (type == null) throw new Exception("Input data is null");

        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployeeInDepartment(type)) {
            if (employee != null && employee.getProjects() == null || employee.getProjects().isEmpty()) {
                result.add(employee);
            }
        }


        return result;

    }


    public ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee != null && employee.getProjects() == null || employee.getProjects().isEmpty()) {
                result.add(employee);
            }
        }


        return result;

    }

    public ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {

        if (lead == null) throw new Exception("Input data is null");


        ArrayList<Employee> result = new ArrayList<>();

        for (Project project : lead.getProjects()) {
            for (Employee employee : EmployeeDAO.getEmployees()) {
                if (employee.getProjects().contains(project)) {
                    result.add(employee);
                }

            }
        }

        result.remove(lead);

        return result;
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
            if (project.getCustomer().equals(customer)) {
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
                if (project.getCustomer().equals(customer)) {
                    result.add(employee);
                }
        }
        return result;


    }


    private ArrayList<Employee> allEmployeeInDepartment(DepartmentType type) throws Exception {

        if (type == null) throw new Exception("Input data is null");
        for (Department department : DepartmentDAO.getDepartments()) {
            if (department != null && department.getType().equals(type)) {
                return department.getEmployees();
            }
        }

        throw new Exception("Cant find this department in DB");
    }
    

}
