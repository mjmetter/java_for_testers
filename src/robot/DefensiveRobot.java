package robot;

import general.Action;
import general.Fighter;

public class DefensiveRobot extends Robot {

    @Override
    public Action getAction() {
        return Action.BLOCK;
    }
}
