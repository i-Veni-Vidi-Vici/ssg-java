package com.sh.order.model.exception;

import com.sh.common.error.ErrorCode;
import lombok.Getter;

public class CreateOrderTransactionException extends RuntimeException {
    @Getter
    private final ErrorCode errorCode;

    public CreateOrderTransactionException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
}
