package br.com.phlimadev.points_of_interest.infra.security;

import br.com.phlimadev.points_of_interest.dtos.ExceptionDTO;
import br.com.phlimadev.points_of_interest.infra.exceptions.NegativeCoordinateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(NegativeCoordinateException.class)
    public ResponseEntity<ExceptionDTO> treatingNegativeCoordinateException(NegativeCoordinateException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
