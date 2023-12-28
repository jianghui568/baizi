package com.yibuyiju.api.dto;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class PredictInfoDTO {

    private String yearGan;
    private String yearGanShiShen;
    private String yearZhi;
    private List<String> yearZhiShiShen;
    private List<String> yearHideGan;

    private String monthGan;
    private String monthGanShiShen;
    private String monthZhi;
    private List<String> monthZhiShiShen;
    private List<String> monthHideGan;

    private String dayGan;
    private String dayGanShiShen;
    private String dayZhi;
    private List<String> dayZhiShiShen;
    private List<String> dayHideGan;

    private String timeGan;
    private String timeGanShiShen;
    private String timeZhi;
    private List<String> timeZhiShiShen;
    private List<String> timeHideGan;

    public static PredictInfoDTO fromLunar(Lunar lunar) {

        EightChar eightChar = lunar.getEightChar();

        PredictInfoDTO predictInfo = new PredictInfoDTO();
        predictInfo.setYearGan(eightChar.getYearGan())
                .setYearZhi(eightChar.getYearZhi())
                .setYearGanShiShen(eightChar.getYearShiShenGan())
                .setYearHideGan(eightChar.getYearHideGan())
                .setYearZhiShiShen(eightChar.getYearShiShenZhi());

        predictInfo.setMonthGan(eightChar.getMonthGan())
                .setMonthZhi(eightChar.getMonthZhi())
                .setMonthGanShiShen(eightChar.getMonthShiShenGan())
                .setMonthHideGan(eightChar.getMonthHideGan())
                .setMonthZhiShiShen(eightChar.getMonthShiShenZhi());

        predictInfo.setDayGan(eightChar.getDayGan())
                .setDayZhi(eightChar.getDayZhi())
                .setDayGanShiShen(eightChar.getDayShiShenGan())
                .setDayHideGan(eightChar.getDayHideGan())
                .setDayZhiShiShen(eightChar.getDayShiShenZhi());

        predictInfo.setTimeGan(eightChar.getTimeGan())
                .setTimeZhi(eightChar.getTimeZhi())
                .setTimeGanShiShen(eightChar.getTimeShiShenGan())
                .setTimeHideGan(eightChar.getTimeHideGan())
                .setTimeZhiShiShen(eightChar.getTimeShiShenZhi());

        return predictInfo;
    }
}
