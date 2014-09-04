package animal;

import general.Action;
import general.Fighter;

public class TweetyBird extends Animal{

    @Override
    public Action getAction(Fighter opponent) {
        if(opponent.getHealth() > 10) {
            return Action.SLEEP;
        }
        return Action.EAT;
    }
}
