public class FareSplitter {

    private String tripId;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripId,
                        double totalFare,
                        int passengerCount) {

        if (tripId == null || tripId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid trip ID");
        }

        if (totalFare < 0) {
            throw new IllegalArgumentException("Fare cannot be negative");
        }

        if (passengerCount <= 0) {
            throw new IllegalArgumentException(
                    "Passenger count must be positive"
            );
        }

        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public double[] fareBreakdown() {

        double[] shares = new double[passengerCount];

        if (passengerCount == 0) {
            return shares;
        }

        double baseShare =
                Math.floor((totalFare / passengerCount) * 100.0)
                / 100.0;

        double assigned = 0.0;

        for (int i = 0; i < passengerCount - 1; i++) {

            shares[i] = baseShare;
            assigned += shares[i];
        }

        shares[passengerCount - 1] =
                Math.round((totalFare - assigned) * 100.0)
                / 100.0;

        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed,
                                         int expected) {

        return confirmed < expected;
    }
}
