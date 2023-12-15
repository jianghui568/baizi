package com.yibuyiju.api.dto;

import com.yibuyiju.api.enums.CalendarEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:31
 */
@Accessors(chain = true, fluent = true)
@Data
public class TesterInfoDTO {
    @ApiModelProperty(value = "是否为真太阳时")
    private Boolean isSolarTime;

    @ApiModelProperty(value = "1阳历，2阴历")
    private CalendarEnum calendarType;

    @ApiModelProperty(value = "生日")
    private String birthday;

    @ApiModelProperty(value = "性别")
    private Integer gender;
}
