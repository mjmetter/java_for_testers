package robot;

import general.Action;
import general.Fighter;

public abstract class Robot extends Fighter{

    @Override
    public void performAction(final Action ownAction) {
        switch (ownAction) {
            case ATTACK:
                attack();
                break;
            case BLOCK:
                block();

        }
    }

}
