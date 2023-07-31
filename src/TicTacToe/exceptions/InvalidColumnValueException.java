package TicTacToe.exceptions;

public class InvalidColumnValueException extends RuntimeException {
    public InvalidColumnValueException(String message) {
        super(message);
    }
}
