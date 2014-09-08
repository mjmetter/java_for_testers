package animal;

import general.Action;

public class Shepard extends Dog {

    @Override
    public Action getAction() {

        return Action.BLOCK;
    }
}
