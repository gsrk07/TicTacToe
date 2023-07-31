package TicTacToe.models;

public class Symbol {

    private char symbolchar;

    public Symbol(char symbol) {
        this.symbolchar = symbol;
    }

    // we only give a getter here so that once a symbol is set, we are not allowing to change it.
    public char getSymbol() {
        return symbolchar;
    }
}
