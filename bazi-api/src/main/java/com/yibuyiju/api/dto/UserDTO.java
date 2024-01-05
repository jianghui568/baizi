package com.yibuyiju.api.dto;

import com.yibuyiju.common.validation.Password;
import com.yibuyiju.common.validation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */

@Data
public class UserDTO {

    @ApiModelProperty(value = "手机号")
    @Phone
    private String phone;

    @ApiModelProperty(value = "密码")
    @Size(min = 6, max = 20, message = "密码长度在6-20之间")
    @Password
    private String password;

    @ApiModelProperty(value = "密码确认")
    @Size(min = 6, max = 20, message = "密码确认长度在6-20之间")
    private String passwordConfirm;

    @ApiModelProperty(value = "验证码")
    private String code;

    private String useragent;
    private String ip;

}
