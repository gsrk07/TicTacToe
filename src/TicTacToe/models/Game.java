package TicTacToe.models;

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
    // here stateofgame cant be DRAW,FAILED,SUCCESS at start of game.
    private Game(List<Player> players, Board board, Player winner, List<Move> moves, GameState statefgame, int indexofnextplayertomove, List<WinningStrategy> winningStrategyList) {
        this.players = players;
        this.board = board;
        this.winner = winner;
        this.moves = moves;
        this.statefgame = statefgame;
        this.indexofnextplayertomove = indexofnextplayertomove;
        this.winningStrategyList = winningStrategyList;
    }


}
