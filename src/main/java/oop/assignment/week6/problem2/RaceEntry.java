public class RaceEntry {

    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;

    public RaceEntry(String bibNumber, double entryFee) {

        if (bibNumber == null || bibNumber.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid bib number");
        }

        if (entryFee <= 0) {
            throw new IllegalArgumentException("Invalid entry fee");
        }

        this.bibNumber = bibNumber.trim();
        this.entryFee = entryFee;
        this.balanceDue = entryFee;
    }

    public void pay(double amount) {
        balanceDue -= amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String announce() {
        return "Race Entry | Bib: " + bibNumber
                + " | Balance: " + balanceDue;
    }
}
