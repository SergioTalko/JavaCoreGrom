package lesson30.hw.DAO;

import lesson30.hw.*;

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
        addProjectToUser("project1", "Vova");
        addProjectToUser("project2", "Ivan");
        addProjectToUser("project2", "Stepan");
        addProjectToUser("project2", "Vova");
        addProjectToUser("project1", "Mat");
        addProjectToUser("project1", "Valerii");

    }


    public static ArrayList<Employee> getEmployees() {
        return employees;
    }


    private Project findProject(String projectName) throws Exception {

        for (Project project : ProjectDAO.getProjects()) {
            if (project.getName().equals(projectName)) {
                return project;
            }
        }
        throw new Exception("CAnt find this project");

    }

    private Employee findEmployee(String name) throws Exception {
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


}