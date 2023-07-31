package TicTacToe.models;

public class Cell {

    private int row;
    private int col;

    private CellState cellState;

    private Player player;

    public Cell(int row, int col, CellState cellState, Player player) {
        this.row = row;
        this.col = col;
        this.cellState = cellState;
        this.player = player;
    }

    // WHEN WE DISPLAY THE BOARD, WE ARE DISPLAYING A GROUP OF CELLS. SO WE NEED A DISPLAY METHOD IN A CELL

    public void display(){

        if(player == null) {
            System.out.println("| |");
        }
        else if (cellState.equals(CellState.BLOCKED)){
            System.out.println(" |||| ");
        }
        else {
            System.out.println(" | " + player.getSymbol().getSymbol() + " | ");
        }
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
