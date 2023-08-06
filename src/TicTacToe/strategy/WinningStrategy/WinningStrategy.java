package TicTacToe.strategy.WinningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface WinningStrategy {

    Player checkWinner(Board board, Move lastmove);

}
