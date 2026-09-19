public class EventTicket {

    protected double balanceDue;

    private double[] lateFeeHistory;
    private int feeCount;

    public EventTicket(double basePrice) {
        balanceDue = basePrice;
        lateFeeHistory = new double[10];
        feeCount = 0;
    }

    public void pay(double amount) {
        balanceDue = balanceDue - amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    protected void applyLateFee(double amount) {

        balanceDue = balanceDue + amount;

        if (feeCount < 10) {
            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }
    }

    public double[] getLateFeeHistory() {

        double[] result = new double[feeCount];

        for (int i = 0; i < feeCount; i++) {
            result[i] = lateFeeHistory[i];
        }

        return result;
    }
}
