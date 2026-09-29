package ludot;

public class Board {

    private static final int STANDARD_PATH_SIZE = 52;
    private static final int HOME_PATH_SIZE = 5;

    private static final int YELLOW_START = 0;
    private static final int BLUE_START = 13;
    private static final int RED_START = 26;
    private static final int GREEN_START = 39;

    private static final int YELLOW_APPROACH = 51;
    private static final int BLUE_APPROACH = 12;
    private static final int RED_APPROACH = 25;
    private static final int GREEN_APPROACH = 38;

    private int[] standardPath;
    private int[] redHomePath;
    private int[] greenHomePath;
    private int[] yellowHomePath;
    private int[] blueHomePath;

    public Board() {

        standardPath = new int[STANDARD_PATH_SIZE];

        for (int i = 0; i < STANDARD_PATH_SIZE; i++) {

            standardPath[i] = i;
        }

        redHomePath = new int[HOME_PATH_SIZE];
        greenHomePath = new int[HOME_PATH_SIZE];
        yellowHomePath = new int[HOME_PATH_SIZE];
        blueHomePath = new int[HOME_PATH_SIZE];

        for (int i = 0; i < HOME_PATH_SIZE; i++) {

            redHomePath[i] = i + 1;
            greenHomePath[i] = i + 1;
            yellowHomePath[i] = i + 1;
            blueHomePath[i] = i + 1;
        }
    }

    public int getStandardPathSize() {

        return STANDARD_PATH_SIZE;
    }

    public int getStartPosition(String colour) {

        if (colour.equals("Yellow")) {
            return YELLOW_START;
        }

        if (colour.equals("Blue")) {
            return BLUE_START;
        }

        if (colour.equals("Red")) {
            return RED_START;
        }

        if (colour.equals("Green")) {
            return GREEN_START;
        }

        return -1;
    }

    public int getApproachPosition(String colour) {

        if (colour.equals("Yellow")) {
            return YELLOW_APPROACH;
        }

        if (colour.equals("Blue")) {
            return BLUE_APPROACH;
        }

        if (colour.equals("Red")) {
            return RED_APPROACH;
        }

        if (colour.equals("Green")) {
            return GREEN_APPROACH;
        }

        return -1;
    }

    public int[] getRedHomePath() {
        return redHomePath;
    }

    public int[] getGreenHomePath() {
        return greenHomePath;
    }

    public int[] getYellowHomePath() {
        return yellowHomePath;
    }

    public int[] getBlueHomePath() {
        return blueHomePath;
    }
}