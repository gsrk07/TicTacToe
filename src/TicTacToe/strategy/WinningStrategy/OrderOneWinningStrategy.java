package TicTacToe.strategy.WinningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy {

    private int dimension;
    private int symboladdedcount;

    /*for O(1) we thought of having the Hashmap approach for each row, each column,
    1 for each diagonal and 1 for all 4 corners.
    */

    private List<HashMap<Character,Integer>> rowsymbolcount = new ArrayList<>(); // []
    private List<HashMap<Character,Integer>> colsymbolcount = new ArrayList<>(); // []

    private HashMap<Character,Integer> topleftdiagonalsymbol = new HashMap<>();

    private HashMap<Character,Integer> bottomleftdiagonalsymbol = new HashMap<>();

    private HashMap<Character,Integer> cornersymbolcount = new HashMap<>();

    public OrderOneWinningStrategy (int dimension){
        this.symboladdedcount = 0;
        this.dimension = dimension;

        for (int i = 0; i < dimension; i++){
            rowsymbolcount.add(new HashMap<>()); // [{}, {}, {}]
            colsymbolcount.add(new HashMap<>()); // [{}, {}, {}]
        }
    }

    // to check for topleftdiagonal

    public boolean isCelltTopleftdiagonal(int row, int col){
        return row == col;
    }

    // to check for bottomleftdiagonal

    public boolean isCellbottomleftdiagonal(int row, int col){

        return row + col == dimension - 1;
    }

    public boolean isCornerCell (int row, int col) {
        boolean result = false;
        // 0,0 || 0,dim-1 || dim-1,0 || dim-1,dim-1

        if (row == 0 || row == dimension - 1) {
            if (col == 0 || col == dimension - 1) {
                result = true;
            }
        }

        return result;
    }



    @Override
    public Player checkWinner(Board board, Move lastmove) {
        return null;
    }
}
