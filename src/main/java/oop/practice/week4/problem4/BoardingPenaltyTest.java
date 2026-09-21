public class BoardingPenaltyTest {

    public static void main(String[] args) {

        BoardingPenaltyCalculator calculator =
                new BoardingPenaltyCalculator(0.01);

        System.out.println(
                calculator.calculatePenalty(1000, 0)
        );

        System.out.println(
                calculator.calculatePenalty(1000, 1)
        );

        System.out.println(
                calculator.calculatePenalty(1000, 16)
        );
    }
}
