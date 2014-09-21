package animal;

import general.Action;

/**
 * Created by timlingerak on 19-09-14.
 */

public class BloodHound extends Dog {
    private int countAttack = 0;
    private int countBlock = 0;
    private int countEat = 0;
    private int countSleep = 0;

    @Override
    public Action getAction() {
        int highestActionCount = 0;
        Action highestAction;
        Action lastAction;


        // Eerste keer altijd blokken.
        // getLastActionOpponent geeft nog geen resultaat!
        if (countAttack == 0 && countBlock == 0 && countEat == 0 && countSleep == 0){
            lastAction = Action.ATTACK;
        }
        else{
            lastAction = getLastActionOpponent();
        }

        // Check de laatst uitgevoerde actie van de opponent, en verhoog bijbehorende teller
        switch (lastAction) {
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

        // Bepaal welke actie de opponent in de voorgaande keren het vaakst heeft uitgevoerd
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

        // Voer de actie uit die de best passende reactie geeft op de meest uitgevoerde actie van de opponent
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
