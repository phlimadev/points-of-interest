package br.com.phlimadev.points_of_interest.infra.exceptions;

public class NegativeCoordinateException extends RuntimeException {
    public NegativeCoordinateException(String message) {
        super(message);
    }
}
