package com.yibuyiju.api.vo;

import com.nlf.calendar.EightChar;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/29 16:58
 */
@Accessors(chain = true)
@Data
public class EightCharVO {
    private String yearGan;
    private String yearDiShi;
    private String yearGanShiShen;
    private String yearZhi;
    private String yearNaYin;
    private List<String> yearZhiShiShen;
    private List<String> yearHideGan;

    private String monthGan;
    private String monthNaYin;
    private String monthDiShi;
    private String monthGanShiShen;
    private String monthZhi;
    private List<String> monthZhiShiShen;
    private List<String> monthHideGan;

    private String dayGan;
    private String dayNaYin;
    private String dayDiShi;
    private String dayGanShiShen;
    private String dayZhi;
    private List<String> dayZhiShiShen;
    private List<String> dayHideGan;

    private String timeGan;
    private String timeNaYin;
    private String timeDiShi;
    private String timeGanShiShen;
    private String timeZhi;
    private List<String> timeZhiShiShen;
    private List<String> timeHideGan;


    public static EightCharVO fromEightChar(EightChar eightChar) {
        EightCharVO eight = new EightCharVO();

        eight.setYearGan(eightChar.getYearGan())
                .setYearZhi(eightChar.getYearZhi())
                .setYearNaYin(eightChar.getYearNaYin())
                .setYearDiShi(eightChar.getYearDiShi())
                .setYearGanShiShen(eightChar.getYearShiShenGan())
                .setYearHideGan(eightChar.getYearHideGan())
                .setYearZhiShiShen(eightChar.getYearShiShenZhi());

        eight.setMonthGan(eightChar.getMonthGan())
                .setMonthZhi(eightChar.getMonthZhi())
                .setMonthNaYin(eightChar.getMonthNaYin())
                .setMonthDiShi(eightChar.getMonthDiShi())
                .setMonthGanShiShen(eightChar.getMonthShiShenGan())
                .setMonthHideGan(eightChar.getMonthHideGan())
                .setMonthZhiShiShen(eightChar.getMonthShiShenZhi());


        eight.setDayGan(eightChar.getDayGan())
                .setDayZhi(eightChar.getDayZhi())
                .setDayNaYin(eightChar.getDayNaYin())
                .setDayDiShi(eightChar.getDayDiShi())
                .setDayGanShiShen(eightChar.getDayShiShenGan())
                .setDayHideGan(eightChar.getDayHideGan())
                .setDayZhiShiShen(eightChar.getDayShiShenZhi());

        eight.setTimeGan(eightChar.getTimeGan())
                .setTimeZhi(eightChar.getTimeZhi())
                .setTimeNaYin(eightChar.getTimeNaYin())
                .setTimeDiShi(eightChar.getTimeDiShi())
                .setTimeGanShiShen(eightChar.getTimeShiShenGan())
                .setTimeHideGan(eightChar.getTimeHideGan())
                .setTimeZhiShiShen(eightChar.getTimeShiShenZhi());

        return eight;
    }
}
