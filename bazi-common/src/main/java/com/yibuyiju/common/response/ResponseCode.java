package com.yibuyiju.common.response;

import lombok.Getter;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/26 16:49
 */
@Getter
public enum ResponseCode {

    SUCCESS(true,200,"成功"),

    FAIL(false,400,"请求失败"),

    NOT_FOUND(false,404,"接口不存在"),

    FORBIDDEN(false,403,"资源拒绝访问"),

    UNAUTHORIZED(false,401,"未认证（签名错误）"),


    INTERNAL_SERVER_ERROR(false,500,"服务器内部错误"),

    VALIDATE_FAIL(false,600,"参数检验失败）");

    /**
     * 响应是否成功
     */

    private Boolean success;

    /**
     * 响应状态码
     */

    private Integer code;

    /**
     * 响应信息
     */

    private String message;

    ResponseCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
