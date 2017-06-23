package org.develop.guru.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Created by Luiz Eduardo on 03/04/2017.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Não retornou resultado!!")
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}
