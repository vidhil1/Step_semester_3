public class CompanyEmployeeRecord {

    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    public static int totalRecords = 0;

    public CompanyEmployeeRecord(
            String name,
            String empId,
            Employee employee,
            ParkingSlot slot) {

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

        String slotInfo;

        if (slot == null) {
            slotInfo = "no parking assigned";
        } else {
            slotInfo = slot.getSlotNo();
        }

        return name
                + " | Pay: Rs "
                + pay
                + " | Slot: "
                + slotInfo;
    }
}
