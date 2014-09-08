package animal;

import general.Action;

public class Eric extends Dog {

    @Override
    public Action getAction() {
        if (getLastActionOpponent() == Action.ATTACK) {
            return Action.BLOCK;
        } else {
            return Action.EAT;
        }
    }
}