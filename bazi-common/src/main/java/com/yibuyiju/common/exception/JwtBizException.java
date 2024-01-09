package com.yibuyiju.common.exception;


import com.yibuyiju.common.response.ResponseCode;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/27 11:15
 */
public class JwtBizException extends BizException {

    public JwtBizException(ResponseCode errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public JwtBizException(ResponseCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public JwtBizException(String message) {
        super(message);
        this.errorCode = ResponseCode.UNAUTHORIZED;
    }

    public JwtBizException(Throwable cause) {
        super(cause);
    }

    public JwtBizException(String message, Throwable cause) {
        super(message, cause);
    }

}
