package lesson30.hw;

public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();


        FirmDAO firmDAO = new FirmDAO();
        System.out.println(firmDAO.getFirm());

        CustomerDAO customerDAO = new CustomerDAO();

        ProjectDAO projects = new ProjectDAO();

        EmployeeDAO employeeDAO = new EmployeeDAO();

        DepartmentDAO department = new DepartmentDAO();


        System.out.println();
        System.out.println(firmDAO.getFirm());

        System.out.println();
        System.out.println(controller.employeesByProject(ProjectDAO.getProjects().get(0)));

    }
}
