public class SrmSystemTest {

    public static void main(String[] args) {

        HostelFeeAccount raviFee =
                new HostelFeeAccount(
                        "RA231100301011",
                        200000,
                        60000
                );

        HostelFeeAccount anithaFee =
                new HostelFeeAccount(
                        "RA231100301012",
                        200000,
                        20000
                );

        HostelFeeAccount karthikFee =
                new HostelFeeAccount(
                        "RA231100301013",
                        200000,
                        0
                );

        /*
         * Valid payment.
         */
        raviFee.pay(0);

        /*
         * Negative payment is rejected.
         */
        anithaFee.pay(-5000);

        HostelRoom[] rooms = {

                new HostelRoom(
                        "C-214",
                        3,
                        2
                ),

                new HostelRoom(
                        "C-507",
                        2,
                        1
                )
        };

        HostelRoom room1 =
                HostelRoom.findAvailableRoom(rooms);

        if (room1 != null) {
            room1.allot("Ravi");
        }

        HostelRoom room2 =
                HostelRoom.findAvailableRoom(rooms);

        if (room2 != null) {
            room2.allot("Anitha");
        }

        SrmStudent ravi =
                new SrmStudent(
                        "Ravi",
                        "RA231100301011",
                        raviFee,
                        room1
                );

        SrmStudent anitha =
                new SrmStudent(
                        "Anitha",
                        "RA231100301012",
                        anithaFee,
                        room2
                );

        SrmStudent karthik =
                new SrmStudent(
                        "Karthik",
                        "RA231100301013",
                        karthikFee,
                        null
                );

        System.out.println(
                ravi.fullStatus()
        );

        System.out.println(
                anitha.fullStatus()
        );

        System.out.println(
                karthik.fullStatus()
        );

        System.out.println(
                "Total students: "
                + SrmStudent.totalStudents
        );
    }
}
