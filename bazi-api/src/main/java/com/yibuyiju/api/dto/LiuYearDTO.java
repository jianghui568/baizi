package com.yibuyiju.api.dto;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
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

    private String lunar;
    private String solar;
    private EightCharDTO eightChar;


    public static LiuYearDTO fromLunar(Lunar lunar, GenderEnum genderEnum) {
        EightChar eightChar = lunar.getEightChar();
        Yun yun = eightChar.getYun(genderEnum.getValue());

        LiuYearDTO predictInfo = new LiuYearDTO();

        predictInfo.setEightChar(EightCharDTO.fromEightChar(eightChar));

        LunarTime lunarTime = lunar.getTime();
        predictInfo.setLunar(lunar.getYearInChinese() + " " + lunar.getMonthInChinese() + " " + lunar.getDayInChinese() + " " + lunarTime.getZhi());

        predictInfo.setSolar(lunar.getSolar().toYmdHms());
        return predictInfo;
    }
}
