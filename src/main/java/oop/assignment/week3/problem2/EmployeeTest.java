public class EmployeeTest {

    public static void main(String[] args) {

        Employee plain =
                new Employee(
                        101,
                        "Aditi",
                        40000
                );

        ManagerEmployee manager =
                new ManagerEmployee(
                        102,
                        "Rohan",
                        70000,
                        8000
                );

        InternEmployee intern =
                new InternEmployee(
                        103,
                        "Meera",
                        12000,
                        10000
                );

        Employee[] employees = {
                plain,
                manager,
                intern
        };

        for (Employee employee : employees) {

            if (employee instanceof ManagerEmployee) {

                ManagerEmployee managerEmployee =
                        (ManagerEmployee) employee;

                System.out.println(
                        "Manager effective pay: Rs "
                        + managerEmployee.effectiveSalary()
                );

            } else if (employee instanceof InternEmployee) {

                InternEmployee internEmployee =
                        (InternEmployee) employee;

                System.out.println(
                        "Intern effective pay: Rs "
                        + internEmployee.effectiveSalary()
                );

            } else {

                System.out.println(
                        "Plain employee pay: Rs "
                        + employee.getSalary()
                );
            }
        }
    }
}
