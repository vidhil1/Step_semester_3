import java.util.Random;

public class RockPaperScissorsGame {

    public static String playRound(
            String playerMove,
            String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock")
                && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper")
                && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors")
                && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(
            Random random) {

        String[] moves = {
                "Rock", "Paper", "Scissors"
        };

        return moves[random.nextInt(3)];
    }

    public static void main(String[] args) {

        String[] playerMoves = {
                "Rock",
                "Paper",
                "Scissors",
                "Rock",
                "Paper"
        };

        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println(
                "Round | Player Move | Computer Move | Result"
        );

        for (int i = 0;
             i < playerMoves.length;
             i++) {

            String playerMove =
                    playerMoves[i];

            String computerMove =
                    generateComputerMove(random);

            String result =
                    playRound(
                            playerMove,
                            computerMove
                    );

            System.out.println(
                    (i + 1)
                    + " | "
                    + playerMove
                    + " | "
                    + computerMove
                    + " | "
                    + result
            );

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage =
                (wins * 100.0)
                / playerMoves.length;

        System.out.println();
        System.out.println(
                "Wins: "
                + wins
                + " | Losses: "
                + losses
                + " | Draws: "
                + draws
                + " | Win % = "
                + winPercentage
                + "%"
        );
    }
}
