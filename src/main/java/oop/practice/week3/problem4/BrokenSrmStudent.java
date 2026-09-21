public class BrokenSrmStudent {

    /*
     * This is intentionally the broken version.
     *
     * name, regNo and attendance should NOT be static
     * because each student needs separate data.
     *
     * Static fields are shared by all objects.
     */

    static String name;
    static String regNo;
    static int attendance;

    public BrokenSrmStudent(
            String name,
            String regNo,
            int attendance) {

        BrokenSrmStudent.name = name;
        BrokenSrmStudent.regNo = regNo;
        BrokenSrmStudent.attendance = attendance;
    }

    public void printIdCard() {

        System.out.println(
                name
                + " | "
                + regNo
        );
    }
}
