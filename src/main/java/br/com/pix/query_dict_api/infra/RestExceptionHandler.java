package br.com.pix.query_dict_api.infra;

import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import br.com.pix.query_dict_api.exception.ErrorMensage;
import br.com.pix.query_dict_api.exception.InvalidKeyTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidKeyTypeException.class)
    public ResponseEntity<ErrorMensage> invalidKeyTypeException(InvalidKeyTypeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMensage(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
    @ExceptionHandler(EntriesNotFoundException.class)
    public ResponseEntity<ErrorMensage>  entriesNotFoundException(EntriesNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMensage(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}
