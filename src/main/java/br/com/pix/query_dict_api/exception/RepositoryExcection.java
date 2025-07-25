package br.com.pix.query_dict_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RepositoryExcection extends RuntimeException{
    public RepositoryExcection(String message) {
        super(message);
    }
}
