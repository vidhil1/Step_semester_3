public class RunnerEntry extends RaceEntry {

    private String category;

    public RunnerEntry(String bibNumber, double entryFee, String category) {
        super(bibNumber, entryFee);
        this.category = category;
    }

    @Override
    public void announce() {
        System.out.println(
            "Runner Entry | Bib: " + bibNumber +
            " | Category: " + category +
            " | Balance: " + balanceDue
        );
    }
}
