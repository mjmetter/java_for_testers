package robot;

//This Robot chat's allot, hope he doesn't bore you to death

import general.Action;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class RoboHan extends Robot {
    String myOpponent = "";
    int getNewAction = 0;
    int roundCounter = 0;

    @Override

    public Action getAction() {
        roundCounter++;
        Action lastActionOpponent = getLastActionOpponent();

        //Generate a random Action
        Action[] values = Action.values();
        Action randomAction = values[(int) (Math.random() * 4)];

        //Get Opponent Name
        if (myOpponent.equals("")) {

            Scanner userInput = new Scanner(System.in);
            System.out.println(trashTalk());
            myOpponent = userInput.next();
        }

        //Say stuff when still Alive
        if (!isAlive()){
            System.out.println("AAARGH je hebt me "+myOpponent +", Ik pak je de volgende keer!");
        }
        System.out.println(imAlive());

        //Give opponent a chance to win against me, he can enter a whole number if he tries something else the exception will be caught.
        try {
            if (roundCounter == Math.ceil(Math.random()*100)) {
                Scanner annoyOpponent = new Scanner(System.in);
                System.out.println("Je hebt geen kans op een overwinning " + myOpponent + ", dus mag jij kiezen wat mijn volgende actie zal zijn:");
                System.out.println("1. ATTACK");
                System.out.println("2. BLOCK");
                System.out.println("3. EAT");
                System.out.println("4. SLEEP");
                getNewAction = annoyOpponent.nextInt();
            }
        } catch (InputMismatchException e){
            System.out.println("Dat is geen nummer vriend! :( Nu heb je me echt boos gemaakt!");
        }

        switch (getNewAction){
            case 1:
                getNewAction = 0;
                return Action.ATTACK;
            case 2:
                getNewAction = 0;
                return Action.BLOCK;
            case 3:
                getNewAction = 0;
                return Action.EAT;
            case 4:
                getNewAction = 0;
                return Action.SLEEP;
        }

        //Decide what action to do
        if (lastActionOpponent == Action.ATTACK){
            System.out.println("Wat is dit "+myOpponent+ "? Wil je me slaan? Haha ik ontwijk je met gemak!");
            return Action.BLOCK;
        }
        if (lastActionOpponent == Action.BLOCK){
            System.out.println("Daar sta je dan niets te doen " +myOpponent+", terwijl ik lekker eet NomNomNom");
            return Action.EAT;
        }
        if (lastActionOpponent == Action.EAT){
            System.out.println("Lekker gegeten "+myOpponent+"? Hier een pak rammel!");
            return Action.ATTACK;
        }
        if (lastActionOpponent == Action.SLEEP){
            System.out.println("Zelfs als je slaapt ben je niet veilig "+myOpponent+" !!");
            return Action.ATTACK;
        }

        System.out.println("Succes "+myOpponent+", Hmm wat zal ik eens gaan doen..");
        return randomAction;

    }

    //Method to generate some preMatch trashTalk
    private String trashTalk() {

        ArrayList<String> listOfTrashTalk = new ArrayList<String >();
        listOfTrashTalk.add("Wie denkt mij te kunnen verslaan? zeg je Naam!");
        listOfTrashTalk.add("Dus jij denkt dat je sterker bent dan mij? wie ben je dan?");
        listOfTrashTalk.add("Zeg je naam zwakkeling!");
        listOfTrashTalk.add("Noem je naam en wellicht versla je mij.. pffff hahaha tuurlijk niet");
        listOfTrashTalk.add("WIE IS DAAR?");
        listOfTrashTalk.add("............BOE! HAHAHAHA wie is daar?");

        Collections.shuffle(listOfTrashTalk);

        return listOfTrashTalk.get(0);

    }

    //Method to Shout stuff when i'm alive
    private String imAlive() {

        ArrayList<String> imAliveList = new ArrayList<String >();
        imAliveList.add("Ik ben onstervelijk!");
        imAliveList.add("Hahahha alle verzet is nutteloos");
        imAliveList.add("Oeh dat kietelt!");
        imAliveList.add("Wil je dat ik mijn mond houd? Doe er wat aan!");
        imAliveList.add("Wat kijk je zuur "+myOpponent+", lukt het niet?");

        Collections.shuffle(imAliveList);

        return imAliveList.get(0);

    }

}