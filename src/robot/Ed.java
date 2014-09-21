package robot;

import general.Action;
import general.Fighter;
import java.util.ArrayList;

public class Ed extends Robot {

    private ArrayList oppActions = new ArrayList();
    private ArrayList myActions = new ArrayList();

    @Override
    public Action getAction() {
        private Action myAction;
        oppActions.add(getLastActionOpponent());

        myAction = Action.BLOCK;
        myActions.add(myAction)
        return myAction;
    }
}