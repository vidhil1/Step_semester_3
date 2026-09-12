public class PatientRecord {

    private String patientId;
    String wardCode;
    protected double vitalsScore;
    public String facilityName;

    public PatientRecord(String patientId, String wardCode,
                         double vitalsScore, String facilityName) {

        String id = patientId.trim();

        if (id.isEmpty() || id.length() < 4) {
            throw new IllegalArgumentException("Invalid patient ID");
        }

        this.patientId = id;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }
}
