public class DeliveryAccount {

    private static double minimumSurgePercent;

    static {
        minimumSurgePercent = 0.01;
    }

    protected String studentId;
    protected double orderValue;
    protected double balanceDue;

    public DeliveryAccount(
            String studentId,
            double orderValue) {

        if (studentId == null
                || studentId.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Invalid student ID"
            );
        }

        if (orderValue <= 0) {
            throw new IllegalArgumentException(
                    "Order value must be positive"
            );
        }

        this.studentId = studentId;
        this.orderValue = orderValue;
        this.balanceDue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0.0);
    }

    public final double calculateSurgeFee(
            int delayMinutes) {

        if (delayMinutes < 0) {
            throw new IllegalArgumentException(
                    "Delay cannot be negative"
            );
        }

        if (delayMinutes == 0) {
            return 0.0;
        }

        double surge = 0.0;

        // Minutes 1–5
        int firstTier =
                Math.min(delayMinutes, 5);

        surge += firstTier
                * orderValue
                * 0.005;

        // Minutes 6–15
        if (delayMinutes > 5) {

            int secondTier =
                    Math.min(delayMinutes, 15) - 5;

            surge += secondTier
                    * orderValue
                    * 0.01;
        }

        // Minute 16 onward
        if (delayMinutes > 15) {

            int thirdTier =
                    delayMinutes - 15;

            surge += thirdTier
                    * orderValue
                    * 0.02;
        }

        double minimumFee =
                orderValue * minimumSurgePercent;

        return Math.max(
                surge,
                minimumFee
        );
    }

    public void processAccount(
            DeliveryAccount account,
            double amount,
            int delayMinutes) {

        if (account == null) {
            return;
        }

        account.balanceDue -= amount;

        double surge =
                account.calculateSurgeFee(
                        delayMinutes
                );

        account.balanceDue += surge;
    }

    public static void processBatch(
            DeliveryAccount[] accounts,
            double[] amounts,
            int[] delayMinutesArray) {

        if (accounts == null
                || amounts == null
                || delayMinutesArray == null) {

            return;
        }

        /*
         * If the arrays have different lengths,
         * only the common portion is processed.
         *
         * This prevents mismatching one student's
         * account with another student's amount/delay.
         */

        int limit = Math.min(
                accounts.length,
                Math.min(
                        amounts.length,
                        delayMinutesArray.length
                )
        );

        int processed = 0;
        int nullSkipped = 0;
        int premium = 0;
        int regular = 0;

        double grandTotalSurgeFees = 0.0;

        for (int i = 0; i < limit; i++) {

            DeliveryAccount account =
                    accounts[i];

            if (account == null) {
                nullSkipped++;
                continue;
            }

            double surge;

            if (account instanceof Premium) {

                Premium premiumAccount =
                        (Premium) account;

                surge =
                        premiumAccount
                                .calculatePremiumSurgeFee(
                                        delayMinutesArray[i]
                                );

                premium++;

            } else {

                surge =
                        account.calculateSurgeFee(
                                delayMinutesArray[i]
                        );

                regular++;
            }

            account.balanceDue -= amounts[i];

            account.balanceDue += surge;

            grandTotalSurgeFees += surge;

            processed++;
        }

        System.out.println(
                processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + premium
                + " premium | "
                + regular
                + " regular | grand total surge fees = "
                + grandTotalSurgeFees
        );
    }
}
