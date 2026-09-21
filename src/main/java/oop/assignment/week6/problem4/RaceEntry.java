public class RaceEntry {

    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;

    public RaceEntry(String bibNumber, double entryFee) {
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        this.balanceDue = entryFee;
    }

    public void pay(double amount) {
        balanceDue -= amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public void announce() {
        System.out.println(
            "Race Entry | Bib: " + bibNumber +
            " | Balance: " + balanceDue
        );
    }
}
