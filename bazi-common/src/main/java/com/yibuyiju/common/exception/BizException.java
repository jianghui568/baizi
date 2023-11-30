package com.yibuyiju.common.exception;


import com.yibuyiju.common.response.ResponseCode;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/27 11:15
 */
public class BizException extends RuntimeException {
    private ResponseCode errorCode;

    public BizException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseCode getErrorCode() {
        return errorCode;
    }
}
