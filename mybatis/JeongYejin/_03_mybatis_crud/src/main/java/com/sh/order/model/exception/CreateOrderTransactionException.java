package com.sh.order.model.exception;

import com.sh.common.error.ErrorCode;
import lombok.Getter;

public class CreateOrderTransactionException extends RuntimeException { // unchecked만 사용 : 간편
    @Getter
    ErrorCode errorCode;

    public CreateOrderTransactionException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
}
