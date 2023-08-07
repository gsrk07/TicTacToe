package TicTacToe.strategy.botPlayingStrategy;

import TicTacToe.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Player player, Board board) {

            // we are simply defining the bot playing strategy as if the bot finds the cell as empty, it will make the move.
            // currently we are not considering to make moves based on difficulty level.

            for (int i = 0; i < board.getSize(); i++) {

                for (int j = 0; j < board.getSize(); j++) {

                    if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                        return new Move(new Cell(i, j), player);
                    }
                }
            }

          return null;
    }
}
