public class BonusCalculator {

    public static String getAuditIfApplicable(StaffMember s) {

        if (s instanceof Auditable) {

            Auditable auditable = (Auditable) s;

            return auditable.auditRecord();
        }

        return "No audit required";
    }
}
