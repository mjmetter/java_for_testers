package animal;

import general.Action;

public class PitBull extends Dog {

    @Override
    public Action getAction() {
        return Action.ATTACK;
    }
}
