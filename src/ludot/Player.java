package ludot;

public class Player {

    private String colour;
    private char symbol;
    private Piece[] pieces;

    public Player(String colour, char symbol) {
        this.colour = colour;
        this.symbol = symbol;
        this.pieces = new Piece[4];

        for (int i = 0; i < 4; i++) {
            pieces[i] = new Piece(symbol + String.valueOf(i + 1), colour);
        }
    }

    public String getColour() {
        return colour;
    }

    public char getSymbol() {
        return symbol;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void displayPieces() {
        System.out.println(
                "The " + colour.toLowerCase() +
                        " player has four (04) pieces named " +
                        pieces[0].getName() + ", " +
                        pieces[1].getName() + ", " +
                        pieces[2].getName() + ", and " +
                        pieces[3].getName() + "."
        );
    }
}