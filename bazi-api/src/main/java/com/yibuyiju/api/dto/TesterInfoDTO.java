package com.yibuyiju.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yibuyiju.api.enums.CalendarEnum;
import com.yibuyiju.api.enums.GenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */

@Data
public class TesterInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    //

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "是否为真太阳时")
    private Boolean isSolarTime;

    @ApiModelProperty(value = "1阳历，2阴历")
    private CalendarEnum calendarType;

    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "性别")
    private GenderEnum gender;
}
