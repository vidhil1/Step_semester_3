public class ReconciliationTest {

    public static void main(String[] args) {

        Premium premium =
                new Premium("STU001", 500);

        DeliveryAccount regular =
                new DeliveryAccount(
                        "STU002",
                        300
                );

        DeliveryAccount[] accounts = {
                premium,
                null,
                regular
        };

        double[] amounts = {
                500,
                400,
                300
        };

        int[] delayMinutesArray = {
                10,
                5,
                0
        };

        DeliveryAccount.processBatch(
                accounts,
                amounts,
                delayMinutesArray
        );
    }
}
