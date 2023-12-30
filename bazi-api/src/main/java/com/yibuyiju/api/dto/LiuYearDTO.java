package com.yibuyiju.api.dto;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
import com.nlf.calendar.eightchar.LiuNian;
import com.nlf.calendar.eightchar.Yun;
import com.yibuyiju.api.enums.GenderEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class LiuYearDTO {

    private Integer year;
    private Integer age;
    private String ganZhi;
    private String xun;
    private String xunKong;

    public static LiuYearDTO fromLunar(LiuNian liuNian) {
        LiuYearDTO nian = new LiuYearDTO();
        nian.setYear(liuNian.getYear())
                .setAge(liuNian.getAge())
                .setGanZhi(liuNian.getGanZhi())
                .setXun(liuNian.getXun())
                .setXunKong(liuNian.getXunKong());
        return nian;
    }
}
