package animal;

import general.Action;

import java.util.ArrayList;

/**
 * Created by timlingerak on 19-09-14.
 */

public class FranticHound extends Dog {
    private ArrayList<Action> previousActionsList = new ArrayList<Action>();
    private boolean firstRound = true;

    @Override
    public Action getAction() {
        int countAttack = 0;
        int countBlock = 0;
        int countEat = 0;
        int countSleep = 0;

        // in de eerste ronde altijd blokken!
        if (firstRound){
            firstRound = false;
            return Action.BLOCK;
        }

        // acties opslaan in een lijst
        previousActionsList.add(getLastActionOpponent());
        // in een loop over de lijst (of de laatste 100 rondes) de verschillende acties tellen

        if (previousActionsList.size() < 100) {
            // verschillende acties tellen in gehele lijst
            for (Action actionItem : previousActionsList){
                switch (actionItem) {
                    case ATTACK:
                        countAttack++;
                        break;
                    case BLOCK:
                        countBlock++;
                        break;
                    case EAT:
                        countEat++;
                        break;
                    case SLEEP:
                        countSleep++;
                        break;
                    default:
                        break;
                }
            }
        }
        else {
            // verschillende acties tellen over laatste 100 ronden
            int arrayIndex = previousActionsList.size() - 1;
            for (int i=0;i<100;i++){
                switch (previousActionsList.get(arrayIndex - i)) {
                    case ATTACK:
                        countAttack++;
                        break;
                    case BLOCK:
                        countBlock++;
                        break;
                    case EAT:
                        countEat++;
                        break;
                    case SLEEP:
                        countSleep++;
                        break;
                    default:
                        break;
                }
            }
        }
        // contra-acties bepalen op meest recente acties van de opponent

        int highestActionCount = 0;
        Action highestAction;

        highestActionCount = countAttack;
        highestAction = Action.ATTACK;
        if (countBlock > highestActionCount){
            highestActionCount = countBlock;
            highestAction = Action.BLOCK;
        }
        if (countEat > highestActionCount){
            highestActionCount = countEat;
            highestAction = Action.EAT;
        }
        if (countSleep > highestActionCount){
            highestActionCount = countSleep;
            highestAction = Action.SLEEP;
        }

        switch (highestAction) {
            case ATTACK:
                return Action.BLOCK;
            case BLOCK:
                return Action.EAT;
            case EAT:
                return Action.ATTACK;
            case SLEEP:
                return Action.ATTACK;
            default:
                throw new IllegalArgumentException("Did you forget to put a break statement in your switch block?");
        }

    }
}
