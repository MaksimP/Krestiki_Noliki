package org.hexlet.xo.exception;

public class CellNotAvailableException extends Exception {

    public CellNotAvailableException() {
        super();
    }

    public CellNotAvailableException(String message) {
        super(message);
    }
}
