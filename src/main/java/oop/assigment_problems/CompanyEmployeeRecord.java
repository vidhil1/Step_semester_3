package oop.assigment_problems;

public class CompanyEmployeeRecord {

    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId,
                                  Employee employee, ParkingSlot slot) {

        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;

        totalRecords++;
    }

    public String fullProfile() {

        double pay;

        if (employee instanceof ManagerEmployee) {

            ManagerEmployee manager =
                    (ManagerEmployee) employee;

            pay = manager.effectiveSalary();

        } else if (employee instanceof InternEmployee) {

            InternEmployee intern =
                    (InternEmployee) employee;

            pay = intern.effectiveSalary();

        } else {

            pay = employee.getSalary();
        }

        String slotNumber;

        if (slot != null) {
            slotNumber = slot.slotNo;
        } else {
            slotNumber = "no parking assigned";
        }

        return name + " | Pay: Rs " + pay
                + " | Slot: " + slotNumber;
    }

    public static void main(String[] args) {

        Employee manager =
                new ManagerEmployee("E001", "Divya", 70000, 8000);

        Employee plain =
                new Employee("E002", "Karan", 40000);

        Employee intern =
                new InternEmployee("E003", "Meera", 12000, 10000);

        ParkingSlot[] slots = {
            new ParkingSlot("A1", 1, 0),
            new ParkingSlot("A2", 1, 0)
        };

        ParkingSlot.safeAllot(slots, "CAR-DIVYA");
        ParkingSlot.safeAllot(slots, "CAR-KARAN");

        ParkingSlot slot1 = slots[0];
        ParkingSlot slot2 = slots[1];

        CompanyEmployeeRecord record1 =
                new CompanyEmployeeRecord(
                        "Divya", "E001", manager, slot1);

        CompanyEmployeeRecord record2 =
                new CompanyEmployeeRecord(
                        "Karan", "E002", plain, slot2);

        CompanyEmployeeRecord record3 =
                new CompanyEmployeeRecord(
                        "Meera", "E003", intern, null);

        System.out.println(record1.fullProfile());
        System.out.println(record2.fullProfile());
        System.out.println(record3.fullProfile());

        System.out.println(
                "Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}