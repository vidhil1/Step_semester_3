public class SrmStudent {

    private String name;
    private String regNo;
    private int attendance;

    private static String university =
            "SRM Institute of Science and Technology";

    private static int admissionCount = 0;

    public SrmStudent(
            String name,
            int attendance) {

        this.name = name;
        this.attendance = attendance;

        admissionCount++;

        this.regNo =
                "RA231100301"
                + String.format(
                        "%03d",
                        admissionCount + 10
                );
    }

    public void printIdCard() {

        System.out.println(
                name
                + " | "
                + regNo
        );
    }

    public static void printTotalAdmissions() {

        System.out.println(
                "Students admitted so far: "
                + admissionCount
        );
    }

    public static String getUniversity() {
        return university;
    }
}
