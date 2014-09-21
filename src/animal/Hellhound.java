package animal;

import general.Action;

import java.util.Random;

/**
 * Created by timlingerak on 19-09-14.
 */

public class Hellhound extends Dog {

    @Override
    public Action getAction() {
        Random rand = new Random();
        int x = rand.nextInt(4);
        switch (x) {
            case 0:
                return Action.ATTACK;
            case 1:
                return Action.BLOCK;
            case 2:
                return Action.EAT;
            case 3:
                return Action.SLEEP;
            default:
                throw new IllegalArgumentException("Did you forget to put a break statement in your switch block?");
        }

    }
}