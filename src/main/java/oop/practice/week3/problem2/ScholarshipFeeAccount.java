public class ScholarshipFeeAccount extends FeeAccount {

    private double scholarshipPercent;

    public ScholarshipFeeAccount(
            String regNo,
            double totalFee,
            double amountPaid,
            double scholarshipPercent) {

        super(regNo, totalFee, amountPaid);

        if (scholarshipPercent < 0) {
            this.scholarshipPercent = 0;
        } else if (scholarshipPercent > 100) {
            this.scholarshipPercent = 100;
        } else {
            this.scholarshipPercent = scholarshipPercent;
        }
    }

    public double effectiveDue() {

        double due = getDue();

        return due
                - (due * scholarshipPercent / 100.0);
    }
}
