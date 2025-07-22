package br.com.pix.query_dict_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntriesNotFoundException extends RuntimeException {

    public EntriesNotFoundException(String message) {
        super(message);
    }
}
