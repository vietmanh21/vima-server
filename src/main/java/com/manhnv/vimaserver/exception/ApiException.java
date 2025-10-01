package com.manhnv.vimaserver.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
