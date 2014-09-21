package robot;

import general.Action;
import static general.Action.*;

public class EdBot extends Robot {
    private String oppActions = "";
    private String myActions = "";
    private int[] trackRecord = {0, 0, 0, 0};
    private Action[] myActionsFromPreviousRound = new Action[4];

    @Override
    public Action getAction() {
        Action[] myNewAction = new Action[4];
        int bestStrategy = 0;
        int score=0;

        if (getLastActionOpponent() != null) {
            //Save all opponent actions and update the track record.
            oppActions = oppActions + getShortActionName(getLastActionOpponent());
            updateTrackRecord();
        }

        //For every strategy: determine my new action
        myNewAction[0] = getRandomAction();
        myNewAction[1] = getMostExecutedAction();
        myNewAction[2] = getPatternBasedAction();
        myNewAction[3] = getMySecretStrategy();

        //Choose strategy with the best track record
        for (int i=0 ; i < trackRecord.length; i++) {
            if (score <= trackRecord[i] && myNewAction[i] != null) {
                score = trackRecord[i];
                bestStrategy = i;
            }
        }

        //Debug output
        /*for (int i=0 ; i < myNewAction.length; i++) {
            System.out.println("Strategy: " + i + ", score: " + trackRecord[i] + ", action: " +  myNewAction[i]);
        }
        System.out.println("Chosen strategy: " + bestStrategy);
        */

        //Keep track of my own actions
        System.arraycopy(myNewAction, 0, myActionsFromPreviousRound, 0, myNewAction.length);
        myActions = myActions + getShortActionName( myNewAction[bestStrategy] );

        return myNewAction[bestStrategy];
    }

    private Action getMySecretStrategy() {
        /*
        A very intelligent strategy based on some magical statistics.
         */
        int rnd;
        Action myAction;

        rnd = (int)(Math.random()* 10);
        if (rnd < 3) {
            myAction = ATTACK;
        } else if (rnd < 8) {
            myAction = BLOCK;
        } else {
            myAction = getMyReaction(EAT);
        }

        return myAction;
    }

    private void updateTrackRecord() {
        /*
        The track record keeps track of the number of successful rounds per strategy.
        Definition of a successful round: my health does not drop faster than my opponents health.
         */
        char oppAction;

        if( getLastActionOpponent() != null){
            oppAction = oppActions.charAt(oppActions.length()-1);

            for (int i = 0; i < myActionsFromPreviousRound.length; i++) {
                if (myActionsFromPreviousRound[i] == ATTACK && oppAction == 'E' ||
                    myActionsFromPreviousRound[i] == ATTACK && oppAction == 'S' ||
                    myActionsFromPreviousRound[i] == BLOCK && oppAction == 'A' ||
                    myActionsFromPreviousRound[i] == EAT && oppAction == 'B' ||
                    myActionsFromPreviousRound[i] == SLEEP && oppAction == 'B') {
                    trackRecord[i] += 1;
                }
            }
            
        }
    }
    
    private Action getPatternBasedAction() {
        /*
        For every possible action: Function counts the number of occurrences of the last x actions + the new action
        in the history of all actions. The action with the highest count is returned and null if no pattern is found.
         */
        Action patternAction = null;
        int count = 0;
        int patternSize;
        String pattern;

        //Some magical formula to determine the pattern size.
        patternSize = Math.max(Math.min(25, (oppActions.length()/15)), 3);

        //Only start counting if the history is long enough
        if ( oppActions.length() > patternSize ) {
            for ( Action action : Action.values() ) {
                pattern = oppActions.substring(oppActions.length() - patternSize);
                pattern += getShortActionName(action);

                if (count < countSubstring(oppActions, pattern)) {
                    patternAction = action;
                    count = countSubstring(oppActions, pattern);
                }
            }
        }
        return getMyReaction(patternAction);
    }

    private Action getMostExecutedAction() {
        /*
        Function calculates which opponent action that has been executed the most and returns my best reaction.
         */
        Action mostExecuted = null;
        int count = 0;

        for (Action action : Action.values()) {
            if (count < countSubstring(oppActions, getShortActionName(action))) {
                mostExecuted = action;
                count = countSubstring(oppActions, getShortActionName(action));
            }
        }
        return getMyReaction(mostExecuted);
    }

    private Action getMyReaction(Action oppAction) {
        /*
        Returns my reaction based on the predicted opponent action.
         */
        Action myAction;

        if (oppAction==null) {
            myAction = null;
        } else {
            switch (oppAction) {
                case ATTACK:
                    myAction = BLOCK;
                    break;
                case BLOCK:
                    myAction = (countSubstring(myActions, "E") + 4) < countSubstring(myActions, "S") ? EAT : SLEEP;
                    break;
                default:
                    //Only attack if health is good enough
                    if (getHealth() > getMaxHealth() * 0.25) {
                        myAction = ATTACK;
                    } else {
                        myAction = (countSubstring(myActions, "E") + 4) < countSubstring(myActions, "S") ? EAT : SLEEP;
                    }
                    break;
            }
        }
        return myAction;
    }
    
    private String getShortActionName(Action action) {
        /*
        Function returns the first character of the action name.
         */
        return String.valueOf(action).substring(0, 1);
    }

    private int countSubstring(String full, String sub) {
        /*
        Function counts the number of occurrences of the sub string in the full string.
         */
        return ( full.length() - full.replaceAll(sub, "").length() ) / sub.length();
    }

    private Action getRandomAction() {
        /*
        Returns a random action.
         */
        return Action.values()[(int)(Math.random()* Action.values().length)];
    }
}