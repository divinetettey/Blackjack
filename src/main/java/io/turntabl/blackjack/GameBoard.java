package io.turntabl.blackjack;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private static int numOfPlayers =3;
    private static List<String> strategyList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome To Blackjack");


        getArguments(args);

        Game game = new Game(numOfPlayers, strategyList);
        game.play();
    }

    /**
     * get arguments from the CLI passed to the program
     * @param args
     */
    private static  void getArguments(String[] args){

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--player") && i + 1 < args.length) {
                strategyList.add(args[i + 1]);
                i++;
            }
            //Adjust number of players to be also retrieved from command line
            else if (args[i].equals("--num-players") && i + 1 < args.length) {
                try {
                    numOfPlayers = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println("An error occurred Invalid number of players supplied " + args[i + 1]);
                    System.exit(1);
                }

            }

            //TODO: get shuffle type also from command line
        }
    }
}