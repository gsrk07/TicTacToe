package TicTacToe.controllers;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategy.WinningStrategy.OrderOneWinningStrategy;

import java.util.List;

// in general,
public class GameController {

    // this is where the game starts.

    // what all do we need for a game? -- board, list of players, winning strategy if we look at Game class,
    // you can find these things to consider.

    public Game createGame(int dimensions, List<Player> players, List<OrderOneWinningStrategy> winningstrategies) {

        // we will write this in a try block as if any exception occurs, it can be catched

        try {

            return Game.builder().setDimensions(dimensions)
                                 .setPlayers(players)
                    .setWinningstrategylist(winningstrategies).build();
        } catch (Exception e){
            System.out.println("Could not start the game, as something went wrong");
        }

        return null;
    }

    // so we are calling thro the game object
    public void displayBoard(Game game){
        game.getBoard().printBoard();
    }

    public GameState getgamestate(Game game) {
        return game.getStatefgame();
    }

    public void executeMove(Game game){

        int nextPlayerindex = game.getIndexofnextplayertomove();
        Player nextplayertoplay = game.getPlayers().get(nextPlayerindex);
        nextplayertoplay.makemove(game.getBoard());

    }

    // for finding the winner of the game
    public String winnerofgame(Game game){
        return game.getWinner().getName();
    }

}
