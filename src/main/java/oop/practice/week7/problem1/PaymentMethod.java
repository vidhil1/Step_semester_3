public abstract class PaymentMethod {

    private static int transactionCounter = 1000;
    private final String transactionId;

    public PaymentMethod() {
        transactionCounter++;
        transactionId = "TXN-" + transactionCounter;
    }

    public abstract String processPayment(double amount);

    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }

    public static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }
}
