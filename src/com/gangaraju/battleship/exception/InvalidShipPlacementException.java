package com.gangaraju.battleship.exception;

/**
 * Created by gangaraju on 7/11/15.
 */
public class InvalidShipPlacementException extends RuntimeException {
    public InvalidShipPlacementException(String message) {
        super(message);
    }
}
