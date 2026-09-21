public class CompanySystemTest {

    public static void main(String[] args) {

        Employee divya =
                new ManagerEmployee(
                        101,
                        "Divya",
                        70000,
                        8000
                );

        Employee karan =
                new Employee(
                        102,
                        "Karan",
                        40000
                );

        Employee meera =
                new InternEmployee(
                        103,
                        "Meera",
                        12000,
                        10000
                );

        ParkingSlot[] slots = {
                new ParkingSlot("A1", 4, 3),
                new ParkingSlot("A2", 5, 4)
        };

        ParkingSlot slot1 =
                ParkingSlot.findAvailableSlot(slots);

        if (slot1 != null) {
            slot1.allot("VEHICLE-DIVYA");
        }

        ParkingSlot slot2 =
                ParkingSlot.findAvailableSlot(slots);

        if (slot2 != null) {
            slot2.allot("VEHICLE-KARAN");
        }

        CompanyEmployeeRecord record1 =
                new CompanyEmployeeRecord(
                        "Divya",
                        "E101",
                        divya,
                        slot1
                );

        CompanyEmployeeRecord record2 =
                new CompanyEmployeeRecord(
                        "Karan",
                        "E102",
                        karan,
                        slot2
                );

        CompanyEmployeeRecord record3 =
                new CompanyEmployeeRecord(
                        "Meera",
                        "E103",
                        meera,
                        null
                );

        System.out.println(
                record1.fullProfile()
        );

        System.out.println(
                record2.fullProfile()
        );

        System.out.println(
                record3.fullProfile()
        );

        System.out.println(
                "Total records: "
                + CompanyEmployeeRecord.totalRecords
        );
    }
}
