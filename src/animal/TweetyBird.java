package animal;

import general.Action;

public class TweetyBird extends Animal{

    @Override
    public Action getAction() {
        return Action.EAT;
    }
}
