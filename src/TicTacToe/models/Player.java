package TicTacToe.models;

import TicTacToe.exceptions.InvalidColumnValueException;
import TicTacToe.exceptions.InvalidRowValueException;

import java.util.Scanner;

public class Player {

    private static int idcounter = 0;
    private String name;

    private Symbol symbol; // we are making it private and creating a class for Symbol since, i dont want anyone to change it.

    private int id;

    private PlayerType playerType;

    private Scanner scanner; // this is used here to give user input.

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.id = idcounter++;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in); // we are not adding Scanner inside constructor since we don't want to create it everytime
    }

    public Move makemove(Board board){

        System.out.println(" Please enter the row for the move ");
        int row = scanner.nextInt();
        System.out.println(" Please enter the column for the move ");
        int col = scanner.nextInt();

        // TO DO is to validate the move and throw exception or message

        if(row < 1 || row >= board.getSize()) {
            throw new InvalidRowValueException("Please enter row value greater than 0 and less than " + board.getSize());
        }

        if(col < 1 || col >= board.getSize()) {
            throw new InvalidColumnValueException("Please enter col value greater than 0 and less than " + board.getSize());
        }

        // we need to return the new cell which takes row, col and current player.
        return new Move(new Cell(row,col,this),this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
