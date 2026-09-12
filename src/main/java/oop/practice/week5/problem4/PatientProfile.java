public class PatientProfile {

    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    // No-argument constructor
    public PatientProfile() {
        this(null, null);
    }

    // Name-only constructor
    public PatientProfile(String name) {
        this(null, name);
    }

    // ID + name constructor
    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }

    // Patient ID getter
    public String getPatientId() {
        return patientId;
    }

    // Patient ID setter - works only once
    public void setPatientId(String id) {
        if (this.patientId == null) {
            this.patientId = id;
        }
    }

    // Name getter
    public String getName() {
        return name;
    }

    // Name setter
    public void setName(String name) {
        this.name = name;
    }

    // Discharged getter
    public boolean isDischarged() {
        return discharged;
    }

    // Discharged setter
    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    // Write-only locker PIN
    public void setLockerPin(String pin) {
        if (pin != null && pin.matches("\\d{4,6}")) {
            this.lockerPin = pin;
        }
    }
}
