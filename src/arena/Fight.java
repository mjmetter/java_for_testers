package arena;

import general.Action;
import general.Fighter;
import general.Results;

public class Fight {
    private int round;
    private int maxRounds;
    private final Fighter fighter1;
    private final Fighter fighter2;

    public Fight(final Fighter fighter1, final Fighter fighter2) {
        this(fighter1, fighter2, 12);
    }

    public Fight(final Fighter fighter1, final Fighter fighter2, final int maxRounds) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.maxRounds = maxRounds;
        round = 1;
    }

    public void fightSingleRound() {
        // only fight when both fighters are still alive..
        if(fighter1.isAlive() && fighter2.isAlive()) {

            // first get actions based on current state
            Action action1 = fighter1.getAction(fighter2);
            Action action2 = fighter2.getAction(fighter1);

            // print actions for sensation
            System.out.println("Player 1 does action: " + action1.name());
            System.out.println("And player 2 does action: " + action1.name());

            // then perform actions
            fighter1.performAction(action1);
            fighter2.performAction(action2);

            System.out.println("Health player 1: " + fighter1.getHealth());
            System.out.println("Health player 2: " + fighter2.getHealth());
        }

        // and last, update round number
        round += 1;

    }

    public boolean isFinished() {
        return round >= maxRounds;
    }

    public int getRound() {
        return round;
    }

    public Results getWinnerDescription() {
        if(fighter1.getHealth() > fighter2.getHealth()) {
            return Results.PLAYER_ONE_WON;
        }
        if(fighter1.getHealth() < fighter2.getHealth()) {
            return Results.PLAYER_TWO_WON;
        }
        return Results.DRAW;
    }
}
