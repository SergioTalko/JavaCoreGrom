package lesson30.hw;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {

    private static ArrayList<Employee> employees = new ArrayList<>();


    public EmployeeDAO() throws Exception {
        employees.add(new Employee("Ivan", "Ivanov", new Date(), Position.DEVELOPER, DepartmentType.PROGRAMMERS));
        addProjectToUser("project1", "Ivan");
        employees.add(new Employee("Vova", "Sidorov", new Date(), Position.TEAM_LEAD, DepartmentType.PROGRAMMERS));
        employees.add(new Employee("Stepan", "Stepanov", new Date(), Position.DEVELOPER, DepartmentType.PROGRAMMERS));
        employees.add(new Employee("Valerii", "Ivanov", new Date(), Position.DEVELOPER, DepartmentType.PROGRAMMERS));
        employees.add(new Employee("Mat", "Smith", new Date(), Position.OTHER, DepartmentType.FINANCES));
        employees.add(new Employee("Petro", "Test", new Date(), Position.TEAM_LEAD, DepartmentType.PROGRAMMERS));
        addProjectToUser("project1", "Vova");
        addProjectToUser("project2", "Ivan");
        addProjectToUser("project2", "Stepan");
        //  addProjectToUser("project2", "Petro");
        addProjectToUser("project1", "Petro");
        //  addProjectToUser("project2", "Vova");
        addProjectToUser("project1", "Mat");
        findEmployee("Valerii").setProjects(new ArrayList<>());

    }

    public static ArrayList<Employee> employeesByProject(Project project) throws Exception {
        if (project == null) throw new Exception("Input data is null");
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().contains(project)) {
                result.add(employee);
            }

        }
        return result;
    }

    public static ArrayList<Project> projectsByEMployee(Employee employee) throws Exception {

        if (employee == null) throw new Exception("Input data is null");
        for (Employee employee1 : employees) {
            if (employee1 != null && employee1.equals(employee)) {
                return employee1.getProjects();
            }
        }

        throw new Exception("Cant find in DB employee with name " + employee.getFirstName());
    }

    public static ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects() == null || employee.getProjects().isEmpty()) {
                result.add(employee);
            }
        }


        return result;

    }

    public static ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {

        if (lead == null) throw new Exception("Input data is null");


        ArrayList<Employee> result = new ArrayList<>();

        for (Project project : lead.getProjects()) {
            for (Employee employee : employees) {
                if (project != null && employee != null && employee.getProjects().contains(project)) {
                    result.add(employee);
                }

            }
        }

        result.remove(lead);

        return result;
    }

    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {

        if (employee == null) throw new Exception("Input data is null");
        ArrayList<Employee> teamLeads = new ArrayList<>();


        for (Project project : employee.getProjects()) {
            for (Employee employee1 : employees) {
                if (employee1 != null && employee1.getProjects().contains(project) && employee1.getPosition() == Position.TEAM_LEAD) {
                    teamLeads.add(employee1);
                }
            }
        }

        return teamLeads;
    }

    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) {

        ArrayList<Employee> result = new ArrayList<>();

        for (Project project : employee.getProjects()) {
            for (Employee employee1 : employees) {
                if (project != null && employee1 != null && employee1.getProjects().contains(project)) {
                    result.add(employee1);
                }
            }
        }
        result.remove(employee);

        return result;
    }

    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {


        if (customer == null) throw new Exception("Input data is null");

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects())
                if (employee != null && project != null && project.getCustomer().equals(customer)) {
                    result.add(employee);
                }
        }
        return result;


    }


    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType type) throws Exception {
        if (type == null) throw new Exception("Input data is null");

        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployeeInDepartment(type)) {
            if (employee != null && employee.getProjects() == null || employee.getProjects().isEmpty()) {
                result.add(employee);
            }
        }


        return result;

    }

    private Project findProject(String projectName) throws Exception {

        if (projectName == null) throw new Exception("Input data is null");
        for (Project project : ProjectDAO.getProjects()) {
            if (project != null && project.getName().equals(projectName)) {
                return project;
            }
        }
        throw new Exception("CAnt find this project");

    }

    private Employee findEmployee(String name) throws Exception {
        if (name == null) throw new Exception("Input data is null");
        for (Employee employee : EmployeeDAO.getEmployees()) {
            if (employee.getFirstName().equals(name)) {
                return employee;
            }
        }
        throw new Exception("Cant find emplyee with name " + name);
    }

    private void addProjectToUser(String projectNAme, String userName) throws Exception {

        Employee resultEmp = findEmployee(userName);
        Project resultProj = findProject(projectNAme);

        ArrayList<Project> result = new ArrayList<>();

        if (resultEmp.getProjects() != null) {
            result.addAll(resultEmp.getProjects());
        }

        result.add(resultProj);

        resultEmp.setProjects(result);


    }

    private static ArrayList<Employee> allEmployeeInDepartment(DepartmentType type) throws Exception {

        if (type == null) throw new Exception("Input data is null");
        for (Department department : DepartmentDAO.getDepartments()) {
            if (department != null && department.getType().equals(type)) {
                return department.getEmployees();
            }
        }

        throw new Exception("Cant find this department in DB");
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }


}
