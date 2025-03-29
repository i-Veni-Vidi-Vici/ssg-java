package com.sh.order.model.exception;

import com.sh.common.error.ErrorCode;
import lombok.Getter;

public class CreateOrderTrasactionException extends RuntimeException {
    @Getter
    ErrorCode errorCode;
    public CreateOrderTrasactionException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
}
