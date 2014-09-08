package animal;

import general.Action;

/**
 * Created by OTC on 8-9-2014.
 */

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