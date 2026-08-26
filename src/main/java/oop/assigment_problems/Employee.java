package oop.assigment_problems;

public class Employee {

    private String empId;
    private String empName;
    private double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {

        Employee plain = new Employee("E001", "Karan", 40000);

        Employee manager = new ManagerEmployee(
                "E002", "Divya", 70000, 8000);

        Employee intern = new InternEmployee(
                "E003", "Meera", 12000, 10000);

        Employee[] employees = {plain, manager, intern};

        for (Employee employee : employees) {

            if (employee instanceof ManagerEmployee) {

                ManagerEmployee managerEmployee =
                        (ManagerEmployee) employee;

                System.out.println(
                        "Manager effective pay: Rs "
                                + managerEmployee.effectiveSalary());

            } else if (employee instanceof InternEmployee) {

                InternEmployee internEmployee =
                        (InternEmployee) employee;

                System.out.println(
                        "Intern effective pay: Rs "
                                + internEmployee.effectiveSalary());

            } else {

                System.out.println(
                        "Plain employee pay: Rs "
                                + employee.getSalary());
            }
        }
    }
}