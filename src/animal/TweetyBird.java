package animal;

import general.Action;
import general.Fighter;

public class TweetyBird extends Bird{

    @Override
    public Action getAction(Fighter opponent) {
        if(opponent.getHealth() > 1) {
            return Action.SLEEP;
        }
        return Action.EAT;
    }
}
