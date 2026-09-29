package ludot;

public class Main {

    public static void main(String[] args) {

        // Create the four players
        Player red = new Player("Red", 'R');
        Player green = new Player("Green", 'G');
        Player yellow = new Player("Yellow", 'Y');
        Player blue = new Player("Blue", 'B');

        // Store players in their fixed cyclic order
        Player[] players = {red, green, yellow, blue};

        // Display each player's pieces
        red.displayPieces();
        green.displayPieces();
        yellow.displayPieces();
        blue.displayPieces();

        // Create the dice
        Dice dice = new Dice();

        // Create the board
        Board board = new Board();

        // Determine which player starts
        Player startingPlayer = determineStartingPlayer(players, dice);

        System.out.println(
                startingPlayer.getColour() +
                        " player has the highest roll and will begin the game."
        );

        // Create the turn order based on the starting player
        Player[] turnOrder = createTurnOrder(players, startingPlayer);

        System.out.println(
                "The order of a single round is " +
                        turnOrder[0].getColour() + ", " +
                        turnOrder[1].getColour() + ", " +
                        turnOrder[2].getColour() + ", and " +
                        turnOrder[3].getColour() + "."
        );
    }

    public static Player determineStartingPlayer(Player[] players, Dice dice) {

        Player[] candidates = players;

        while (candidates.length > 1) {

            int[] rolls = new int[candidates.length];
            int highestRoll = 0;

            // Roll the dice for all remaining candidates
            for (int i = 0; i < candidates.length; i++) {

                rolls[i] = dice.roll();

                System.out.println(
                        candidates[i].getColour() + " rolls " + rolls[i]
                );

                if (rolls[i] > highestRoll) {
                    highestRoll = rolls[i];
                }
            }

            // Count how many players rolled the highest value
            int numberOfHighestRollers = 0;

            for (int roll : rolls) {

                if (roll == highestRoll) {
                    numberOfHighestRollers++;
                }
            }

            // Store only the players who rolled the highest value
            Player[] newCandidates = new Player[numberOfHighestRollers];

            int index = 0;

            for (int i = 0; i < candidates.length; i++) {

                if (rolls[i] == highestRoll) {
                    newCandidates[index] = candidates[i];
                    index++;
                }
            }

            // If there is still a tie, tied players roll again
            if (numberOfHighestRollers > 1) {

                System.out.println(
                        "There is a tie for the highest roll. Tied players will roll again."
                );
            }

            candidates = newCandidates;
        }

        return candidates[0];
    }

    public static Player[] createTurnOrder(
            Player[] players,
            Player startingPlayer) {

        Player[] turnOrder = new Player[players.length];

        int startingIndex = 0;

        // Find the starting player's position in the player array
        for (int i = 0; i < players.length; i++) {

            if (players[i] == startingPlayer) {
                startingIndex = i;
                break;
            }
        }

        // Build the cyclic turn order
        for (int i = 0; i < players.length; i++) {

            int playerIndex =
                    (startingIndex + i) % players.length;

            turnOrder[i] = players[playerIndex];
        }

        return turnOrder;
    }
}