package animal;

import general.Action;
import general.Fighter;

public abstract class Animal extends Fighter{

    protected double hunger = -1;

    public final void eat() {
        hunger = hunger - 0.2;
    }

    @Override
    public void performAction(final Action ownAction) {
        switch (ownAction) {
            case ATTACK:
                attack();
                break;
            case BLOCK:
                block();
                break;
            case EAT:
                eat();
                break;
            case SLEEP:
                sleep();
                break;
            default:
                throw new IllegalArgumentException("Did you forget to put a break statement in your switch block?");
        }
    }
}
