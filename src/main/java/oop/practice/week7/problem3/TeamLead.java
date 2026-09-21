public class TeamLead extends StaffMember implements Auditable {

    private int teamSize;

    public TeamLead(double baseSalary, int teamSize) {
        this(baseSalary, 0.10, teamSize);
    }

    public TeamLead(double baseSalary,
                    double bonusRate,
                    int teamSize) {

        super(baseSalary, bonusRate);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * bonusRate;
    }

    @Override
    public String auditRecord() {
        return "TeamLead audit: "
                + teamSize
                + " team members, salary $"
                + getSalary();
    }
}
