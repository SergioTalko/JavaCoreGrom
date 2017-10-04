package lesson30.hw;

import java.util.ArrayList;

public class Project {
    String name;
    Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }

    public String getName() {
        return name;
    }
}
