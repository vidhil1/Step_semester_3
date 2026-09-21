public class SrmStudent {

    private String name;
    private String regNo;
    private int attendance;

    public SrmStudent(
            String name,
            String regNo,
            int attendance) {

        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public void addAttendanceUpdate(int newAttendance) {
        attendance = newAttendance;
    }

    public boolean isEligible() {
        return attendance >= 75;
    }

    /*
     * isEligible() is an instance method because it checks
     * the attendance of one particular student.
     *
     * classAverage() is static because it calculates the
     * average across multiple SrmStudent objects.
     */
    public static double classAverage(
            SrmStudent[] students) {

        if (students == null || students.length == 0) {
            return 0.0;
        }

        int total = 0;

        for (SrmStudent student : students) {
            if (student != null) {
                total += student.attendance;
            }
        }

        return (double) total / students.length;
    }

    public String getName() {
        return name;
    }

    public int getAttendance() {
        return attendance;
    }

    public static void main(String[] args) {

        SrmStudent[] students = {

                new SrmStudent(
                        "Ravi",
                        "RA231100301011",
                        82
                ),

                new SrmStudent(
                        "Anitha",
                        "RA231100301012",
                        68
                ),

                new SrmStudent(
                        "Karthik",
                        "RA231100301013",
                        91
                ),

                new SrmStudent(
                        "Meera",
                        "RA231100301014",
                        74
                ),

                new SrmStudent(
                        "Suresh",
                        "RA231100301015",
                        60
                )
        };

        for (SrmStudent student : students) {

            String status;

            if (student.isEligible()) {
                status = "Eligible";
            } else {
                status = "Detained";
            }

            System.out.println(
                    student.getName()
                    + " - "
                    + student.getAttendance()
                    + "% - "
                    + status
            );
        }

        System.out.println(
                "Class average: "
                + classAverage(students)
                + "%"
        );
    }
}
