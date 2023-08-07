package TicTacToe.models;

import TicTacToe.exceptions.DuplicateSymbolException;
import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidDimensionException;
import TicTacToe.exceptions.InvalidPlayersCountException;
import TicTacToe.strategy.WinningStrategy.OrderOneWinningStrategy;

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

    private List<OrderOneWinningStrategy> winningStrategyList;

    // we know that we want to create the Game object only after we are done validation of the attributes.
    // we will use Builder design pattern to validate our attributes and then create our Game class object.

    // we make our game class constructor as private, since it should not be accessible to anyone.

    // out of these attributes, when we pass something thro constructor means it is something we expect to have at start of the game.
    // here stateofgame, we will not pass in constructor, but have its value assigned as IN_PROGRESS.

    // we dont know which player will be the winner. Hence we will not pass winner.
    // we dont need to pass the list of moves, and index of next player as well at the start of the game in constructor.

    // also here we are saying users can choose which winning strategy they want to choose to decide the winner.

    private Game(List<Player> players, Board board, /*Player Winner*/ /*List<Move> moves, int indexofnextplayertomove, */ List<OrderOneWinningStrategy> winningStrategyList) {
        this.players = players;
        this.board = board;
        //this.winner = winner; // cannot decide on winner in the initial setup time
        this.moves = new ArrayList<Move>();
        this.statefgame = GameState.IN_PROGRESS; // initially whenever a game is created, it will be in progress.
        this.indexofnextplayertomove = 0; // initially would be 0
        this.winningStrategyList = winningStrategyList;
    }

    // inside our parent class, as per builder pattern we make the builder method which will
    // return a new Builder object. using this object, we start taking user inputs, i.e. thro setters
    // and then call the build method.


    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getStatefgame() {
        return statefgame;
    }

    public int getIndexofnextplayertomove() {
        return indexofnextplayertomove;
    }

    public List<OrderOneWinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public static Builder builder() {
        return new Builder();
    }
    // we will be using Builder Design Pattern here,  since we want to validate our data first.

    public static class Builder {

        private List<Player> players;
        private List<OrderOneWinningStrategy> winningstrategylist;
        private int dimensions; // we need to validate the dimensions first before creating the board for the game.

        public Builder() {
            // would like to have initial default values only.
            this.players = new ArrayList<Player>();
            this.winningstrategylist = new ArrayList<OrderOneWinningStrategy>();
            this.dimensions = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningstrategylist(List<OrderOneWinningStrategy> winningstrategylist) {
            this.winningstrategylist = winningstrategylist;
            return this;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        // we also give methods to add Player and Winning Strategy since both of them are list.
        // and at a later stage before starting the game, we can add players.

        public void addPlayer(Player player) {
            players.add(player);
        }

        public void addWinningStrategy(OrderOneWinningStrategy winningStrategy){
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
                hs.add(player.getSymbol().getSymbolchar());
            }

            if(hs.size() != players.size()){
                throw new DuplicateSymbolException("Every Player should have unique symbol only");
            }

        }

        // this is the validate method where we will perform all validations in the builder class
        private void validate() {
            validatebotcount();
            validateDimensions();
            validatenumberofplayers();
            validateUniqueSymbolforAllPlayers();

        }

        // this build() method should be public, since we have to call this from the controller
        public Game build(){
            validate();
            return new Game(players,new Board(dimensions),winningstrategylist);
        }

    }



}
