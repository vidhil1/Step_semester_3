public class FleetReconciliationTest {

    public static void main(String[] args) {

        Sleeper sleeper =
                new Sleeper("BK001", 2000);

        BusTicketAccount regular =
                new BusTicketAccount("BK002", 1200);

        BusTicketAccount[] accounts = {
                sleeper,
                null,
                regular
        };

        double[] amounts = {
                1200,
                900,
                700
        };

        int[] minutesLate = {
                10,
                5,
                0
        };

        BusTicketAccount.processBatch(
                accounts,
                amounts,
                minutesLate
        );
    }
}
