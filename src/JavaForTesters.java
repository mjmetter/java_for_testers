import animal.TweetyBird;
import arena.Fight;
import general.Fighter;
import robot.DefensiveRobot;
import robot.KillerRobot;

public class JavaForTesters {

    public static void main(String[] args) {
        Fighter fighterInRedCorner = new DefensiveRobot();
        Fighter fighterInBlueCorner = new TweetyBird();

        Fight fight = new Fight(fighterInRedCorner, fighterInBlueCorner, 10);
        while (!fight.isFinished()) {
            System.out.println("Round " + fight.getRound() + ":");
            fight.fightSingleRound();
            System.out.println("The bell! End of round " + fight.getRound() + "\n");
        }

        System.out.println(fight.getWinnerDescription().getDescription());
    }
}
