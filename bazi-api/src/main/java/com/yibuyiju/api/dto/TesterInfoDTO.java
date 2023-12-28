package com.yibuyiju.api.dto;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.yibuyiju.api.enums.CalendarEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
    @EnumValue
    private CalendarEnum calendarType;

    @ApiModelProperty(value = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "性别")
    private Integer gender;
}
