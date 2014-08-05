package robot;

import general.Action;
import general.Fighter;

public class DefensiveRobot extends Robot {

    @Override
    public Action getAction(Fighter opponent) {
        return Action.BLOCK;
    }
}
