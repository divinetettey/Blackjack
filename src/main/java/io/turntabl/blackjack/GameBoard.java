package io.turntabl.blackjack;

public class GameBoard {

    private static final int DEFAULT_NO_PLAYERS =6;
    public static void main(String[] args){
       // int numOfPlayers = DEFAULT_NO_PLAYERS;
        System.out.println("Welcome To Blackjack");

        Game game = new Game(DEFAULT_NO_PLAYERS);
        game.play();

//        for(int i = 0; i < args.length; i++) {
//            List<String> strategies = Arrays.asList("default");
//            if(args[i].equals("--player") && i + 1 < args.length){
//                strategies.add(args[i+ 1]);
//                i++;
//            }
//            //Adjust number of players to be also retrieved from command line
//            else if(args[i].equals("--num-players") && i + 1 < args.length){
//                try {
//                    numOfPlayers = Integer.parseInt(args[i+1]);
//                }catch (NumberFormatException e) {
//                    System.out.println("An error occurred Invalid number of players supplied " + args[i + 1]);
//                    System.exit(1);
//                }
//
//            }
            //TODO: get shuffle type also from command line
        }

        //TODO: Implement the game and play


//        Deck deck = new Deck();
//        deck.initialize();
//
//        System.out.println(deck.toString());

}
