package com.technogise.chessproblem.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ChessException extends Exception {
    public ChessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChessException(String message) {
        super(message);
    }

    public ChessException(Throwable cause) {
        super(cause);
    }
}
