package com.yibuyiju.api.vo;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
import com.nlf.calendar.eightchar.Yun;
import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.util.LunarExtend;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * https://6tail.cn/calendar/api.html
 *
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class PredictInfoVO {

    private List<PredictBaseInfoVO> baseInfoList;
    private String name;
    private String gender;
    private String xingZuo;
    private String xiu;
    private String lunar;
    private String fullDescription;
    private String solar;
    private String shengXiao;
    private String shengXiaoLiChun;
    private String shengXiaoExact;
    private String jieQiCurrent;
    private String jieQiCurrentDateTime;
    private String jieQiPrev;
    private String jieQiPrevDateTime;
    private String jieQiNext;
    private String jieQiNextDateTime;
    private String gong;
    private EightCharVO eightChar;
    private List<DaYunVO> daYunList;
    private String kongYear;
    private String gongMonth;
    private String gongDay;
    private String gongHour;

    private String xunKongYear;
    private String xunKongMonth;
    private String xunKongDay;
    private String xunKongHour;

    public static PredictInfoVO fromLunar(LunarExtend lunarExtend, TesterDTO tester) {
        PredictInfoVO predictInfo = new PredictInfoVO();

        Lunar lunar = lunarExtend.getLunar();

        predictInfo.setName(tester.getName());
        predictInfo.setGender(tester.getGender().getText());
        predictInfo.setXingZuo(lunar.getSolar().getXingZuo());


        predictInfo.setXiu(lunar.getXiu());
        predictInfo.setFullDescription(lunar.toFullString());

        predictInfo.setShengXiao(lunar.getYearShengXiao());
        predictInfo.setShengXiaoLiChun(lunar.getYearShengXiaoByLiChun());
        predictInfo.setShengXiaoExact(lunar.getYearShengXiaoExact());

        predictInfo.setGong(lunar.getGong());

        if (Objects.nonNull(lunar.getCurrentJieQi())) {
            predictInfo.setJieQiCurrent(lunar.getCurrentJieQi().getName());
            predictInfo.setJieQiCurrentDateTime(lunar.getCurrentJieQi().getSolar().toYmdHms());
        }

        if (Objects.nonNull(lunar.getPrevJieQi()) && Objects.nonNull(lunar.getPrevJieQi().getName())) {
            predictInfo.setJieQiPrev(lunar.getPrevJieQi().getName());
            predictInfo.setJieQiPrevDateTime(lunar.getPrevJieQi().getSolar().toYmdHms());
        }
        if (Objects.nonNull(lunar.getNextJieQi()) && Objects.nonNull(lunar.getNextJieQi().getName())) {
            predictInfo.setJieQiNext(lunar.getNextJieQi().getName());
            predictInfo.setJieQiNextDateTime(lunar.getNextJieQi().getSolar().toYmdHms());
        }


        // 八字
        EightChar eightChar = lunar.getEightChar();

        predictInfo.setEightChar(EightCharVO.fromEightChar(eightChar));

        // 空亡
        predictInfo.setXunKongHour(eightChar.getTimeXunKong());
        predictInfo.setXunKongDay(eightChar.getDayXunKong());
        predictInfo.setXunKongMonth(eightChar.getMonthXunKong());
        predictInfo.setXunKongYear(eightChar.getYearXunKong());

        // 大运
        Yun yun = eightChar.getYun(tester.getGender().getValue());
        predictInfo.setDaYunList(PredictInfoVO.makeDaYunList(yun));

        LunarTime lunarTime = lunar.getTime();
        predictInfo.setLunar(lunar.getYearInChinese() + " " + lunar.getMonthInChinese() + " " + lunar.getDayInChinese() + " " + lunarTime.getZhi());

        predictInfo.setSolar(lunar.getSolar().toYmdHms());

        predictInfo.setBaseInfoList(predictInfo.generateBaseInfoList(lunarExtend));
        return predictInfo;
    }

    protected static List<DaYunVO> makeDaYunList(Yun yun) {
        List<DaYunVO> list = new ArrayList<>();

        Arrays.stream(yun.getDaYun())
                .skip(1)
                .forEach(item -> {
                    list.add(DaYunVO.fromDaYun(item));
                });

        return list;
    }

    protected List<PredictBaseInfoVO> generateBaseInfoList(LunarExtend lunarExtend) {
        List<PredictBaseInfoVO> list = new ArrayList<>();
        list.add(PredictBaseInfoVO.builder().title("姓名：").subTitle(this.name).build());
        list.add(PredictBaseInfoVO.builder().title("性别：").subTitle(this.gender).build());
        list.add(PredictBaseInfoVO.builder().title("阴历：").subTitle(this.solar).build());
        list.add(PredictBaseInfoVO.builder().title("阳历：").subTitle(this.lunar).build());

        String jieQi = this.jieQiPrev + " " + this.jieQiPrevDateTime + "  " + this.jieQiNext + " " + this.jieQiNextDateTime;
        list.add(PredictBaseInfoVO.builder().title("出生节气：").subTitle(jieQi).build());
        list.add(PredictBaseInfoVO.builder().title("星座：").subTitle(this.xingZuo).build());
        list.add(PredictBaseInfoVO.builder().title("二十八宿：").subTitle(this.xiu).build());

        String xunKong = this.xunKongYear + " " + this.xunKongMonth + " " + this.xunKongDay + " " + this.xunKongHour;
        list.add(PredictBaseInfoVO.builder().title("空亡(年月日时)：").subTitle(xunKong).build());
        list.add(PredictBaseInfoVO.builder().title("命宫：").subTitle(lunarExtend.getMingGong()).build());
        list.add(PredictBaseInfoVO.builder().title("身宫：").subTitle(lunarExtend.getShenGong()).build());
        list.add(PredictBaseInfoVO.builder().title("胎元：").subTitle(lunarExtend.getTaiYuan()).build());
        list.add(PredictBaseInfoVO.builder().title("：").subTitle(this.xiu).build());
        return list;
    }
}
