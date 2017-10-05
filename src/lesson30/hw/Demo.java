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
       // System.out.println(controller.employeesByProject(ProjectDAO.getProjects().get(0)));
        //System.out.println(controller.projectsByEMployee(EmployeeDAO.getEmployees().get(0)));
       // System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.PROGRAMMERS));
       // System.out.println(controller.employeesWithoutProject());
        //System.out.println(controller.employeesByTeamLead(EmployeeDAO.getEmployees().get(1)));
       // System.out.println(controller.teamLeadsByEmployee(EmployeeDAO.getEmployees().get(0)));
       // System.out.println(controller.employeesByProjectEmployee(EmployeeDAO.getEmployees().get(0)));
       // System.out.println(controller.projectsByCustomer(CustomerDAO.getCustomers().get(0)));
        System.out.println(controller.employeesByCustomerProjects(CustomerDAO.getCustomers().get(0)));


    }
}
