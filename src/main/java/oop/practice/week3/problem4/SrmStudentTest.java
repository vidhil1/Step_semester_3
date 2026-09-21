public class SrmStudentTest {

    public static void main(String[] args) {

        System.out.println("Broken version:");

        BrokenSrmStudent first =
                new BrokenSrmStudent(
                        "Ravi",
                        "RA231100301011",
                        82
                );

        BrokenSrmStudent second =
                new BrokenSrmStudent(
                        "Meera",
                        "RA231100301012",
                        74
                );

        first.printIdCard();
        second.printIdCard();

        System.out.println(
                "(Ravi's data was overwritten - "
                + "both students now show Meera)"
        );

        System.out.println();

        System.out.println("Fixed version:");

        SrmStudent student1 =
                new SrmStudent(
                        "Ravi",
                        82
                );

        SrmStudent student2 =
                new SrmStudent(
                        "Meera",
                        74
                );

        student1.printIdCard();
        student2.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}
