package br.com.pix.query_dict_api.infra;

import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import br.com.pix.query_dict_api.exception.DecoderMessageHandler;
import br.com.pix.query_dict_api.exception.InvalidKeyTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidKeyTypeException.class)
    public ResponseEntity<DecoderMessageHandler> invalidKeyTypeException(InvalidKeyTypeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DecoderMessageHandler(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(EntriesNotFoundException.class)
    public ResponseEntity<DecoderMessageHandler> entriesNotFoundException(EntriesNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DecoderMessageHandler(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DecoderMessageHandler> runtimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DecoderMessageHandler(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }
}
