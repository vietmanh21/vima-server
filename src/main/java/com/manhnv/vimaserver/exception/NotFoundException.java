package com.manhnv.vimaserver.exception;

import com.manhnv.vimaserver.utils.MessagesUtils;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String message;

    public NotFoundException(String errorCode, Object... var2) {
        this.message = MessagesUtils.getMessage(errorCode, var2);
    }
}
