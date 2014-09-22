package robot;

import general.Action;
import general.Fighter;

public class Eric extends Fighter {

    int attacks = 0;
    int eats = 0;
    //int sleeps = 0;
    int blocks = 0;


    @Override
    public Action getAction() {
        System.out.println("Are you up for it? " + attacks);
        getLastActionOpponent();


        if (attacks > 1){
            attacks = attacks - 2;
            return Action.BLOCK;

        }

        if (getLastActionOpponent() == null){
            return Action.EAT;
        }

        if (getLastActionOpponent() == Action.ATTACK) {
            attacks = attacks + 1;
            return Action.BLOCK;

        }

        if (getLastActionOpponent() == Action.EAT){
            eats = eats + 2;
            return Action.ATTACK;

        }
        if (getLastActionOpponent() == Action.BLOCK){
            blocks = blocks + 1;
            return Action.EAT;

        }
        return Action.ATTACK;

    }

}
