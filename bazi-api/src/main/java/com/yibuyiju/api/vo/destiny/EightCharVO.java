package com.yibuyiju.api.vo.destiny;

import com.nlf.calendar.EightChar;
import com.yibuyiju.api.util.eightchar.LunarExtend;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/29 16:58
 */
@Accessors(chain = true)
@Data
public class EightCharVO {

    private ZhuInfoVO year;
    private ZhuInfoVO month;
    private ZhuInfoVO day;
    private ZhuInfoVO hour;

    public static EightCharVO fromEightChar(EightChar eightChar) {
        EightCharVO eight = new EightCharVO();

        ZhuInfoVO yearZhu = new ZhuInfoVO();
        yearZhu.setGan(eightChar.getYearGan())
                .setZhi(eightChar.getYearZhi())
                .setNaYin(eightChar.getYearNaYin())
                .setDiShi(eightChar.getYearDiShi())
                .setGanShiShen(eightChar.getYearShiShenGan())
                .setCang(eightChar.getYearHideGan())
                .setZhiShiShen(eightChar.getYearShiShenZhi())
                .setXunKong(eightChar.getYearXunKong())
                .setZhangSheng(LunarExtend.getZhangSheng(eightChar.getYearGan(), eightChar.getYearZhi()));


        ZhuInfoVO monthZhu = new ZhuInfoVO();
        monthZhu.setGan(eightChar.getMonthGan())
                .setZhi(eightChar.getMonthZhi())
                .setNaYin(eightChar.getMonthNaYin())
                .setDiShi(eightChar.getMonthDiShi())
                .setGanShiShen(eightChar.getMonthShiShenGan())
                .setCang(eightChar.getMonthHideGan())
                .setZhiShiShen(eightChar.getMonthShiShenZhi())
                .setXunKong(eightChar.getMonthXunKong())
                .setZhangSheng(LunarExtend.getZhangSheng(eightChar.getMonthGan(), eightChar.getMonthZhi()));


        ZhuInfoVO dayZhu = new ZhuInfoVO();
        dayZhu.setGan(eightChar.getDayGan())
                .setZhi(eightChar.getDayZhi())
                .setNaYin(eightChar.getDayNaYin())
                .setDiShi(eightChar.getDayDiShi())
                .setGanShiShen(eightChar.getDayShiShenGan())
                .setCang(eightChar.getDayHideGan())
                .setZhiShiShen(eightChar.getDayShiShenZhi())
                .setXunKong(eightChar.getDayXunKong())
                .setZhangSheng(LunarExtend.getZhangSheng(eightChar.getDayGan(), eightChar.getDayZhi()));

        ZhuInfoVO hourZhu = new ZhuInfoVO();
        hourZhu.setGan(eightChar.getTimeGan())
                .setZhi(eightChar.getTimeZhi())
                .setNaYin(eightChar.getTimeNaYin())
                .setDiShi(eightChar.getTimeDiShi())
                .setGanShiShen(eightChar.getTimeShiShenGan())
                .setCang(eightChar.getTimeHideGan())
                .setZhiShiShen(eightChar.getTimeShiShenZhi())
                .setXunKong(eightChar.getTimeXunKong())
                .setZhangSheng(LunarExtend.getZhangSheng(eightChar.getTimeGan(), eightChar.getTimeZhi()));

        eight.setYear(yearZhu)
                .setMonth(monthZhu)
                .setDay(dayZhu)
                .setHour(hourZhu);

        return eight;
    }
}
