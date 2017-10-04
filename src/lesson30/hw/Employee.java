package lesson30.hw;

import lesson30.hw.DAO.DepartmentDAO;
import lesson30.hw.DAO.ProjectDAO;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private DepartmentType department;
    private ArrayList<Project> projects;

    public Employee(String firstName, String lastName, Date dateHired, Position position, DepartmentType department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;

    }

    public Employee(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public Employee(Project projects) {
        this.projects.add(projects);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
