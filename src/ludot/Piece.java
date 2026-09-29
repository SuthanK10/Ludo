package ludot;

public class Piece {

    private String name;
    private String colour;
    private int position;
    private boolean inBase;

    public Piece(String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.position = -1;
        this.inBase = true;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getPosition() {
        return position;
    }

    public boolean isInBase() {
        return inBase;
    }
}