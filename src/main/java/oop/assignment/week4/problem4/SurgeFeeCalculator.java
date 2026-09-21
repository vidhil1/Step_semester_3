public final class SurgeFeeCalculator {

    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {

        if (minimumSurgePercent < 0) {
            throw new IllegalArgumentException(
                    "Minimum surge percent cannot be negative"
            );
        }

        this.minimumSurgePercent =
                minimumSurgePercent;
    }

    public final double calculateSurgeFee(
            double orderValue,
            int delayMinutes) {

        if (orderValue < 0) {
            throw new IllegalArgumentException(
                    "Order value cannot be negative"
            );
        }

        if (delayMinutes < 0) {
            throw new IllegalArgumentException(
                    "Delay minutes cannot be negative"
            );
        }

        // No delay = no surge fee.
        if (delayMinutes == 0) {
            return 0.0;
        }

        double tieredFee = 0.0;

        // Minutes 1–5: 0.5% per minute
        int firstTier =
                Math.min(delayMinutes, 5);

        tieredFee += firstTier
                * orderValue
                * 0.005;

        // Minutes 6–15: 1% per minute
        if (delayMinutes > 5) {

            int secondTier =
                    Math.min(delayMinutes, 15) - 5;

            tieredFee += secondTier
                    * orderValue
                    * 0.01;
        }

        // Minute 16 onward: 2% per minute
        if (delayMinutes > 15) {

            int thirdTier =
                    delayMinutes - 15;

            tieredFee += thirdTier
                    * orderValue
                    * 0.02;
        }

        double minimumFee =
                orderValue * minimumSurgePercent;

        return Math.max(
                tieredFee,
                minimumFee
        );
    }
}
