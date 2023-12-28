package com.yibuyiju.common.exception;


import com.yibuyiju.common.response.ResponseCode;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/27 11:15
 */
public class VerifyBizException extends BizException {

    public VerifyBizException(ResponseCode errorCode) {
        super(errorCode);
    }

    public VerifyBizException(String message) {
        super(message);
    }

    public VerifyBizException(Throwable cause) {
        super(cause);
    }

    public VerifyBizException(String message, Throwable cause) {
        super(message, cause);
    }

}
