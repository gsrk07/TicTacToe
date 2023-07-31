package TicTacToe.models;

import java.util.Scanner;

public class Player {

    private String name;

    private Symbol symbol; // we are making it private and creating a class for Symbol since, i dont want anyone to change it.

    private int id;

    private PlayerType playerType;

    private Scanner scanner; // this is used here to give user input.

    public Player(String name, Symbol symbol, int id, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in); // we are not adding Scanner inside constructor since we dont want to create it everytime
    }

    public Move makemove(Board board){

        System.out.println(" Please enter the row for the move ");
        int row = scanner.nextInt();
        System.out.println(" Please enter the column for the move ");
        int col = scanner.nextInt();

        // TO DO is to validate the move and throw exception or message



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
