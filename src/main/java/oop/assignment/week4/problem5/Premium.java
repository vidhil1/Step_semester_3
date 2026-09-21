public class Premium extends DeliveryAccount {

    public Premium(
            String studentId,
            double orderValue) {

        super(studentId, orderValue);
    }

    public Premium(String studentId) {
        super(studentId);
    }

    public double calculatePremiumSurgeFee(
            int delayMinutes) {

        return super.calculateSurgeFee(
                delayMinutes
        ) * 1.5;
    }
}
