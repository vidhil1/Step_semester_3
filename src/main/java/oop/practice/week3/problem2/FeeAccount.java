public class FeeAccount {

    private String regNo;
    private double totalFee;
    private double amountPaid;

    public FeeAccount(
            String regNo,
            double totalFee,
            double amountPaid) {

        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    public void pay(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Payment rejected: amount must be positive"
            );
            return;
        }

        if (amount > getDue()) {
            amountPaid = totalFee;
        } else {
            amountPaid += amount;
        }
    }

    public double getDue() {
        return totalFee - amountPaid;
    }

    public String getRegNo() {
        return regNo;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
