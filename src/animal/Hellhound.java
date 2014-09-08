package animal;

import general.Action;

public class Hellhound extends Dog {

    @Override
    public Action getAction() {
        if (this.getHealth() == this.getMaxHealth()){
            return Action.SLEEP;
        }
        else {
            switch (this.getLastActionOpponent()) {
                case BLOCK:
                    return Action.EAT;
                case ATTACK:
                    return Action.BLOCK;
                case EAT:
                    return Action.ATTACK;
                default:
                    return Action.ATTACK;
            }
        }
    }
}