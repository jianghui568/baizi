package com.yibuyiju.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/26 16:43
 */
@ApiModel
@Data
public class Response<T> {
    @ApiModelProperty(value = "返回码", example = "200")
    private Integer code;
    @ApiModelProperty(value = "返回码描述", example = "ok")
    private String message;
    @ApiModelProperty(value = "响应时间", example = "2020-08-12 14:37:11")
    private Date timestamp = new Date();
    @ApiModelProperty(value = "返回结果")
    private T data;


    protected Response() {
    }

    protected Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Response<T> success(T data) {
        return new Response<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Response<T> success(T data, String message) {
        return new Response<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Response<T> failed(ResponseCode errorCode) {
        return new Response<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> Response<T> failed(ResponseCode errorCode, String message) {
        return new Response<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Response<T> failed(String message) {
        return new Response<T>(ResponseCode.FAIL.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> Response<T> failed() {
        return failed(ResponseCode.FAIL);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Response<T> validateFailed() {
        return failed(ResponseCode.VALIDATE_FAIL);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Response<T> validateFailed(String message) {
        return new Response<T>(ResponseCode.VALIDATE_FAIL.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Response<T> unauthorized(T data) {
        return new Response<T>(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Response<T> forbidden(T data) {
        return new Response<T>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage(), data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
