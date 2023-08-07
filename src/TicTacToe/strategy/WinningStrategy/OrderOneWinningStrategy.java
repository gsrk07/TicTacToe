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

    private HashMap<Character,Integer> topleftdiagonalsymbolcount = new HashMap<>();

    private HashMap<Character,Integer> bottomleftdiagonalsymbolcount = new HashMap<>();

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

    public boolean isCellTopleftdiagonal(int row, int col){
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

      /*
            0,0     0,1     0,2
            1,0     1,1     1,2
            2,0     2,1     2,2

            row -> 0 || dim-1
            col -> 0 || dim-1
     */

    @Override
    public Player checkWinner(Board board, Move lastmove) {

        Player lastmovedplayer = lastmove.getPlayer();
        char symboloflastmovedplayer = lastmovedplayer.getSymbol().getSymbolchar(); // get my symob
        int row = lastmove.getCell().getRow();
        int col = lastmove.getCell().getCol();

        if(checkforRows(row,col,symboloflastmovedplayer,lastmove) != null){
            return lastmovedplayer;
        }
        else if(checkforColumns(row,col,symboloflastmovedplayer,lastmove) != null) {
            return lastmovedplayer;
        }
        else if(checkforDiagonalWins(row,col,symboloflastmovedplayer,lastmove) != null){
            return lastmovedplayer;
        }
        else if(checkforCornerWins(row,col,symboloflastmovedplayer,lastmove) != null){
            return lastmovedplayer;
        }



        return null;
    }

    // we now write the logic for how to check for rows
    private Player checkforRows(int row, int col, char charofsymbol, Move lastmove){

        if(!rowsymbolcount.get(row).containsKey(charofsymbol)){
            rowsymbolcount.get(row).put(charofsymbol,0);
        }

        rowsymbolcount.get(row).put(
                charofsymbol, // key
                rowsymbolcount.get(row).get(charofsymbol)+1); // value

        if(rowsymbolcount.get(row).get(charofsymbol) == dimension){
            return lastmove.getPlayer();
        }

        return null;
    }

    private Player checkforColumns(int row, int col, char charofsymbol, Move lastmove){

        if(!colsymbolcount.get(col).containsKey(charofsymbol)){
            colsymbolcount.get(col).put(charofsymbol,0);
        }

        colsymbolcount.get(col).
                put(charofsymbol, // key
                    colsymbolcount.get(col).get(charofsymbol)+1); // value to be incremented to the symbol

        if(colsymbolcount.get(col).size() == dimension){
            return lastmove.getPlayer();
        }

        return null;
    }

    private Player checkforDiagonalWins(int row, int col, char charofsymbol, Move lastmove){

            if(isCellTopleftdiagonal(row,col){
                if(!topleftdiagonalsymbolcount.containsKey(charofsymbol)){
                    topleftdiagonalsymbolcount.put(charofsymbol,0);
                }

                topleftdiagonalsymbolcount.put(charofsymbol,
                        topleftdiagonalsymbolcount.get(charofsymbol)+1);

                if(topleftdiagonalsymbolcount.size() == dimension){
                    return lastmove.getPlayer();
                }
            }

            if(isCellbottomleftdiagonal(row,col)){
                if(!bottomleftdiagonalsymbolcount.containsKey(charofsymbol)){
                    bottomleftdiagonalsymbolcount.put(charofsymbol,0);
                }

                bottomleftdiagonalsymbolcount.put(charofsymbol,
                        bottomleftdiagonalsymbolcount.get(charofsymbol)+1);

                if(bottomleftdiagonalsymbolcount.size() == dimension){
                    return lastmove.getPlayer();
                }
            }

        return null;
    }



}
