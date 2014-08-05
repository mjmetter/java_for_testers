package general;

public enum Results {
    DRAW("It's a draw: Both fighters were killed in the fight."),
    PLAYER_ONE_WON("Player one has won!"),
    PLAYER_TWO_WON("Player two has won!");

    private Results(final String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

}
