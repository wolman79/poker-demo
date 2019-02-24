package io.advance.poker.exceptions;

/**
 * A {@link RuntimeException} that indicates an exception originated in this project's codebase.
 */
@SuppressWarnings("serial")
public class PokerGameException extends RuntimeException {

    public PokerGameException(String message) {
        super(message);
    }

    public PokerGameException(String message, Throwable cause) {
        super(message, cause);
    }

}
