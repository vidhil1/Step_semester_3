public class BusTicketAccount {

    private static double penaltyRate;

    static {
        penaltyRate = 0.01;
    }

    protected String bookingId;
    protected double ticketFare;
    protected double balanceDue;

    public BusTicketAccount(String bookingId, double ticketFare) {

        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Invalid booking ID"
            );
        }

        if (ticketFare <= 0) {
            throw new IllegalArgumentException(
                    "Ticket fare must be positive"
            );
        }

        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
        this.balanceDue = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 0.0);
    }

    public final double calculatePenalty(int minutesLate) {

        if (minutesLate < 0) {
            throw new IllegalArgumentException(
                    "Minutes late cannot be negative"
            );
        }

        return ticketFare * penaltyRate * minutesLate;
    }

    public void pay(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Payment cannot be negative"
            );
        }

        balanceDue -= amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public void processAccount(
            BusTicketAccount account,
            double amount,
            int minutesLate) {

        if (account == null) {
            return;
        }

        account.pay(amount);

        double penalty =
                account.calculatePenalty(minutesLate);

        account.balanceDue += penalty;
    }

    public static void processBatch(
            BusTicketAccount[] accounts,
            double[] amounts,
            int[] minutesLateArray) {

        if (accounts == null) {
            return;
        }

        int processed = 0;
        int nullSkipped = 0;
        int sleeper = 0;
        int regular = 0;

        double grandTotalPenalties = 0.0;

        int limit = accounts.length;

        if (amounts != null) {
            limit = Math.min(limit, amounts.length);
        }

        if (minutesLateArray != null) {
            limit = Math.min(limit, minutesLateArray.length);
        }

        for (int i = 0; i < limit; i++) {

            BusTicketAccount account = accounts[i];

            if (account == null) {
                nullSkipped++;
                continue;
            }

            double penalty =
                    account.calculatePenalty(
                            minutesLateArray[i]
                    );

            if (account instanceof Sleeper) {

                Sleeper sleeperAccount =
                        (Sleeper) account;

                penalty =
                        sleeperAccount.calculatePenalty(
                                minutesLateArray[i]
                        );

                sleeper++;
            } else {
                regular++;
            }

            account.pay(amounts[i]);

            account.balanceDue += penalty;

            grandTotalPenalties += penalty;

            processed++;
        }

        System.out.println(
                processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + sleeper
                + " sleeper | "
                + regular
                + " regular | grand total penalties = "
                + grandTotalPenalties
        );
    }
}
