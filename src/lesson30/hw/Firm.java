package lesson30.hw;

import lesson30.hw.DAO.CustomerDAO;
import lesson30.hw.DAO.DepartmentDAO;

import java.util.ArrayList;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private ArrayList<Department> departments;
    private ArrayList<Customer> customers;


    public Firm(Date dateFounded, ArrayList<Department> departments, ArrayList<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                ", departments=" + departments +
                ", customers=" + customers +
                '}';
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
