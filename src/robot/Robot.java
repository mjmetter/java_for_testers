package robot;

import general.Action;
import general.Fighter;

public abstract class Robot extends Fighter{

    @Override
    public double block() {
        return 2 * defence;
    }

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
