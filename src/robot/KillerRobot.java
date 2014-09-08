package robot;

import general.Action;
import general.Fighter;

public class KillerRobot extends Robot{

    @Override
    public Action getAction() {
        return Action.ATTACK;
    }
}
