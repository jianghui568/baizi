package com.yibuyiju.api.vo;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
import com.nlf.calendar.eightchar.Yun;
import com.yibuyiju.api.dto.TesterDTO;
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

    public static PredictInfoVO fromLunar(Lunar lunar, TesterDTO tester) {
        PredictInfoVO predictInfo = new PredictInfoVO();

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

        if (Objects.nonNull(lunar.getPrevJieQi().getName())) {
            predictInfo.setJieQiPrev(lunar.getPrevJieQi().getName());
            predictInfo.setJieQiPrevDateTime(lunar.getPrevJieQi().getSolar().toYmdHms());
        }
        if (Objects.nonNull(lunar.getNextJieQi().getName())) {
            predictInfo.setJieQiNext(lunar.getNextJieQi().getName());
            predictInfo.setJieQiNextDateTime(lunar.getNextJieQi().getSolar().toYmdHms());
        }


        // 八字
        EightChar eightChar = lunar.getEightChar();

        predictInfo.setEightChar(EightCharVO.fromEightChar(eightChar));


        // 大运
        Yun yun = eightChar.getYun(tester.getGender().getValue());
        predictInfo.setDaYunList(PredictInfoVO.makeDaYunList(yun));

        LunarTime lunarTime = lunar.getTime();
        predictInfo.setLunar(lunar.getYearInChinese() + " " + lunar.getMonthInChinese() + " " + lunar.getDayInChinese() + " " + lunarTime.getZhi());

        predictInfo.setSolar(lunar.getSolar().toYmdHms());

        predictInfo.setBaseInfoList(predictInfo.generateBaseInfoList());
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

    protected List<PredictBaseInfoVO> generateBaseInfoList() {
        List<PredictBaseInfoVO> list = new ArrayList<>();
        return list;
    }
}
