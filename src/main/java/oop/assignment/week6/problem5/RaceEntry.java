public class RaceEntry {

    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;

    private static int bibCounter = 0;
    private final String entryCode;

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

        bibCounter++;
        entryCode = "BIB-" + bibCounter;
    }

    public void pay(double amount) {
        balanceDue -= amount;
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public static boolean isValidDiscountCode(String code) {

        if (code == null || code.length() != 5) {
            return false;
        }

        if (code.charAt(0) != 'M') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(3))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(4))) {
            return false;
        }

        return true;
    }

    public static int getBibCounter() {
        return bibCounter;
    }

    public static String settleNight(RaceEntry[] entries) {

        int processed = 0;
        int nullSkipped = 0;
        int relay = 0;
        int individual = 0;

        for (RaceEntry entry : entries) {

            if (entry == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (entry instanceof RelayTeamEntry) {
                relay++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + relay + " relay | "
                + individual + " individual";
    }
}
