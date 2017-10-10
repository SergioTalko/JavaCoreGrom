package lesson30.hw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Firm {
    private Date dateFounded;
    private Set<Department> departments;
    private ArrayList<Customer> customers;


    public Firm(Date dateFounded, Set<Department> departments, ArrayList<Customer> customers) {
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

    public Set<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }



    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
