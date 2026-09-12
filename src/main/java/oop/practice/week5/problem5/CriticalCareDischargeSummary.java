public class CriticalCareDischargeSummary extends DischargeSummary {

    private final int icuDays;

    public CriticalCareDischargeSummary(
            String patientId,
            String[] medicationCodes,
            int icuDays) {

        super(patientId, medicationCodes);

        if (icuDays < 0) {
            throw new IllegalArgumentException("Invalid ICU days");
        }

        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }
}
