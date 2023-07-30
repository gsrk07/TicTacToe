package TicTacToe.models;

import TicTacToe.exceptions.DuplicateSymbolException;
import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidDimensionException;
import TicTacToe.exceptions.InvalidPlayersCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;

    private Player winner;

    private List<Move> moves;

    private GameState statefgame;

    private int indexofnextplayertomove;

    private List<WinningStrategy> winningStrategyList;

    // we know that we want to create the Game object only after we are done validation of the attributes.
    // we will use Builder design pattern to validate our attributes and then create our Game class object.

    // we make our game class constructor as private, since it should not be accessible to anyone.

    // out of these attributes, when we pass something thro constructor means it is something we expect to have at start of the game.
    // here stateofgame, we will not pass in constructor, but have its value assigned as IN_PROGRESS.

    // we dont know which player will be the winner. Hence we will not pass winner.

    private Game(List<Player> players, Board board, /*Player Winner*/ List<Move> moves, int indexofnextplayertomove ,List<WinningStrategy> winningStrategyList) {
        this.players = players;
        this.board = board;
        //this.winner = winner;
        this.moves = new ArrayList<Move>();
        this.statefgame = GameState.IN_PROGRESS;
        this.indexofnextplayertomove = 0; // initially would be 0
        this.winningStrategyList = winningStrategyList;
    }

    // we will be using Builder class here.

    public static class Builder{

        private List<Player> players;
        private List<WinningStrategy> winningstrategylist;
        private int dimensions; // we need to validate the dimensions first before creating the board for the game.

        public Builder() {
            // would like to have initial default values only.
            this.players = new ArrayList<Player>();
            this.winningstrategylist = new ArrayList<WinningStrategy>();
            this.dimensions = 0;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningstrategylist(List<WinningStrategy> winningstrategylist) {
            this.winningstrategylist = winningstrategylist;
        }

        public void setDimensions(int dimensions) {
            this.dimensions = dimensions;
        }

        // we also give methods to add Player and Winning Strategy since both of them are list.

        public void addPlayer(Player player) {
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy){
        winningstrategylist.add(winningStrategy);
        }

        // now we start writing validations

        private void validatebotcount() {

            int botcount = 0;

            for(Player player : players){

                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botcount++;
                }
            }

            if(botcount > 1){
                // throw exception here.
                throw new InvalidBotCountException("Bot count has exceeded 1");
            }

        }

        private void validateDimensions() {

            // we want to support a tictactoe with N = 3 to N = 10.
            if(dimensions < 3 || dimensions > 10){
                throw new InvalidDimensionException("Dimensions can either be less than 11 or greater than 2");
            }
        }

        private void validatenumberofplayers() {

            // number of players playing the game should be dimension-1.

            if(players.size() != dimensions-1){
                throw new InvalidPlayersCountException("Insufficient number of players");
            }

        }

        // SO EACH PLAYER SHOULD HAVE A UNIQUE SYMBOL ONLY. So if we find more than one symbol it means
        // duplicate or extra symbol exists.
        private void validateUniqueSymbolforAllPlayers(){

            HashSet<Character> hs = new HashSet<>();

            for(Player player : players){
                hs.add(player.getSymbol());
            }

            if(hs.size() != players.size()){
                throw new DuplicateSymbolException("Every Player should have unique symbol only");
            }

        }


    }



}
