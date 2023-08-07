package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GameController gc = new GameController(); // THIS WILL CONTROL THE GAME

        System.out.println(" Please enter the dimension of the game" );
        int dimension = sc.nextInt();

        System.out.println(" Will there be any bot in the game ? Y/N ");
        String isbotpresent = sc.next();

        List<Player> players = new ArrayList<>();
        int iteratorcount = dimension - 1; // this is just a count for us to see how many times to iterate to take the input for players.

        if(isbotpresent.equals("Y")){
            iteratorcount = dimension - 2;
        }

        for(int i = 0; i < iteratorcount; i++){

            System.out.println(" What is the name of the Player number " + (i+1));
            String playername = sc.next();

            System.out.println(" What is the character symbol of the Player number " + (i+1));
            String charsymbol = sc.next();

            // inserted player object inside list.
            players.add(new Player(playername,new Symbol(charsymbol.charAt(0)), PlayerType.HUMAN));

        }

        // BOT IS PRESENT

        if(isbotpresent.equals("Y")){

            System.out.println(" What is the name of the Bot " );
            String playername = sc.next();

            System.out.println(" What is the character symbol of the Bot " );
            String charsymbol = sc.next();

            // inserted player object inside list.
            players.add(new Player(playername,new Symbol(charsymbol.charAt(0)), PlayerType.BOT));

        }


        Game game = gc.createGame(dimension,players);

        while (game.getStatefgame().equals(GameState.IN_PROGRESS)){

            System.out.println("Current board status");
            gc.displayBoard(game);

            gc.executeMove(game);
        }

        System.out.println(" Game has ended. result was: ");

        if(gc.getgamestate(game).equals(GameState.DRAW)){
            System.out.println("Game is a draw");
        }
        else {
            System.out.println("Game is won by: " + gc.winnerofgame(game));
        }

    }
}
