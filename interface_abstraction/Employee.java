package interface_abstraction;

public class Employee extends User{

    private Integer employeeId;
    private String department;

    public Employee(String username, String email,Integer employeeId, String department) {
        super(username, email);
        this.employeeId = employeeId;
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("employeeId: " + employeeId);
        System.out.println("department: " + department);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("john_smith", "john.smith@example.com", 201, "Human Resources");
        System.out.println("Username: " + employee.getUsername());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Department: " + employee.getDepartment());
        employee.displayInfo();
    }

}
