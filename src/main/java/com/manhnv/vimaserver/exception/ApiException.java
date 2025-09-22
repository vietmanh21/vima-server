package com.manhnv.vimaserver.exception;

import com.manhnv.vimaserver.common.IErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
