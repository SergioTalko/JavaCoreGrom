package lesson30.hw.DAO;

import lesson30.hw.Customer;
import lesson30.hw.Project;

import java.util.ArrayList;

public class ProjectDAO {

    private static ArrayList<Project> projects = new ArrayList<>();
    private CustomerDAO customerDAO;


    public ProjectDAO() throws Exception {
        projects.add(new Project("project1", findCustomer("customer1")));
        projects.add(new Project("project2", findCustomer("customer2")));

    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    private Customer findCustomer(String customerName) throws Exception {
        for (Customer customer1 : customerDAO.getCustomers()) {
            if (customer1.getName().equals(customerName)) {
                return customer1;
            }
        }
        throw new Exception("Cant find customer with name " + customerName);
    }
}
