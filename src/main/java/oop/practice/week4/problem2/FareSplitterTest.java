public class FareSplitterTest {

    public static void main(String[] args) {

        FareSplitter split =
                new FareSplitter("TRIP001", 100000, 3);

        double[] result = split.fareBreakdown();

        for (double share : result) {
            System.out.println(share);
        }

        FareSplitter provisional =
                new FareSplitter("TRIP003");

        double[] provisionalResult =
                provisional.fareBreakdown();

        for (double share : provisionalResult) {
            System.out.println(share);
        }

        System.out.println(
                split.isConfirmationOverdue(2, 3)
        );

        System.out.println(
                split.isConfirmationOverdue(3, 3)
        );
    }
}
