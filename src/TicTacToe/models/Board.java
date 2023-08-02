package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    private List<List<Cell>> board;

    public Board(int size) {

        this.size = size; // 3
        this.board = new ArrayList<>(); // [    ]

        for(int i = 0; i < size; i++){

            this.getBoard().add(new ArrayList<>());

            /*[ []
              []
              [] ]*/

            for(int j = 0; j < size; j++){
                this.getBoard().get(i).add(new Cell(i,j)); // this line makes sure we add a new cell to each of the list.
            }

        }
    }

    public void printBoard() {

        for (int i = 0; i < size; i++){

            List<Cell> eachrow = board.get(i);

            for (int j = 0; j < eachrow.size(); j++){
                eachrow.get(j).display();
            }
            System.out.println(); // to change the row.
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
