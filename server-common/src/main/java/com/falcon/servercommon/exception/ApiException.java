package com.falcon.servercommon.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
