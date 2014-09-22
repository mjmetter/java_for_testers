import animal.TweetyBird;
import arena.Fight;
import general.Fighter;
import robot.DefensiveRobot;
import robot.EdBot;
import robot.Eric;
import robot.KillerRobot;

public class JavaForTesters {

    public static void main(String[] args) {
        Fighter fighterInRedCorner = new Eric();
        Fighter fighterInBlueCorner = new EdBot();

        Fight fight = new Fight(fighterInRedCorner, fighterInBlueCorner, 10);
        while (!fight.isFinished()) {
            System.out.println("Round " + fight.getRound() + ":");
            fight.fightSingleRound();
            System.out.println("The bell! End of round " + (fight.getRound() - 1) + "\n");
        }

        System.out.println(fight.getWinnerDescription().getDescription());
    }
}
