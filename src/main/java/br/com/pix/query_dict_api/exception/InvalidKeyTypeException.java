package br.com.pix.query_dict_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidKeyTypeException extends RuntimeException {
    public InvalidKeyTypeException(String s) {
        super(s);
    }
}
