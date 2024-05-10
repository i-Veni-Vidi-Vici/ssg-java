package com.sh.order.model.exception;

import com.sh.common.error.ErrorCode;

public class CreatOrderTransactionException extends Throwable {
    ErrorCode errorCode;
    public CreatOrderTransactionException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
}
