package com.yibuyiju.api.vo.destiny;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.util.eightchar.LunarExtend;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 基础信息
 *
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:44
 */
@Data
public class BaseInfoVO {
    private List<BaseInfoItemVO> infoList;

    private String name;
    private String gender;
    private String xingZuo;
    private String xiu;
    private String lunar;
    private String fullDescription;
    private String solar;
    private String shengXiao;
    private String jieQiCurrent;
    private String jieQiCurrentDateTime;
    private String jieQiPrev;
    private String jieQiPrevDateTime;
    private String jieQiNext;
    private String jieQiNextDateTime;

    // 空亡
    private String xunKongYear;
    private String xunKongMonth;
    private String xunKongDay;
    private String xunKongHour;

    private String mingGong;
    private String shenGong;
    private String taiYuan;

    public static BaseInfoVO fromLunar(LunarExtend lunarExtend, TesterDTO tester) {
        BaseInfoVO baseInfo = new BaseInfoVO();
        Lunar lunar = lunarExtend.getLunar();

        lunar.getDayJiShen();

        baseInfo.setName(tester.getName());
        baseInfo.setGender(tester.getGender().getText());
        baseInfo.setXingZuo(lunar.getSolar().getXingZuo());


        baseInfo.setXiu(lunar.getXiu());
        baseInfo.setFullDescription(lunar.toFullString());

        baseInfo.setShengXiao(lunar.getYearShengXiaoExact());

        baseInfo.setJieQiCurrent("");
        baseInfo.setJieQiCurrentDateTime("");
        if (Objects.nonNull(lunar.getCurrentJieQi())) {
            baseInfo.setJieQiCurrent(lunar.getCurrentJieQi().getName());
            baseInfo.setJieQiCurrentDateTime(lunar.getCurrentJieQi().getSolar().toYmdHms());
        }

        baseInfo.setJieQiPrev("");
        baseInfo.setJieQiPrevDateTime("");
        if (Objects.nonNull(lunar.getPrevJieQi()) && Objects.nonNull(lunar.getPrevJieQi().getName())) {
            baseInfo.setJieQiPrev(lunar.getPrevJieQi().getName());
            baseInfo.setJieQiPrevDateTime(lunar.getPrevJieQi().getSolar().toYmdHms());
        }

        baseInfo.setJieQiNext("");
        baseInfo.setJieQiNextDateTime("");
        if (Objects.nonNull(lunar.getNextJieQi()) && Objects.nonNull(lunar.getNextJieQi().getName())) {
            baseInfo.setJieQiNext(lunar.getNextJieQi().getName());
            baseInfo.setJieQiNextDateTime(lunar.getNextJieQi().getSolar().toYmdHms());
        }

        EightChar eightChar = lunar.getEightChar();

        // 空亡
        baseInfo.setXunKongHour(eightChar.getTimeXunKong());
        baseInfo.setXunKongDay(eightChar.getDayXunKong());
        baseInfo.setXunKongMonth(eightChar.getMonthXunKong());
        baseInfo.setXunKongYear(eightChar.getYearXunKong());

        LunarTime lunarTime = lunar.getTime();
        baseInfo.setLunar(lunar.getYearInChinese() + " " + lunar.getMonthInChinese() + " " + lunar.getDayInChinese() + " " + lunarTime.getZhi());
        baseInfo.setSolar(lunar.getSolar().toYmdHms());

        baseInfo.generateInfoList();
        return baseInfo;
    }

    public void generateInfoList() {
        List<BaseInfoItemVO> list = new ArrayList<>();
        list.add(BaseInfoItemVO.build("姓名：", this.name));
        list.add(BaseInfoItemVO.build("性别：", this.gender));
        list.add(BaseInfoItemVO.build("生肖：", this.shengXiao));
        list.add(BaseInfoItemVO.build("阴历：", this.solar));
        list.add(BaseInfoItemVO.build("阳历：", this.lunar));

        String jieQi = this.jieQiPrev + " " + this.jieQiPrevDateTime + "  " + this.jieQiNext + " " + this.jieQiNextDateTime;
        list.add(BaseInfoItemVO.build("出生节气：", jieQi));
        list.add(BaseInfoItemVO.build("星座：", this.xingZuo));
        list.add(BaseInfoItemVO.build("二十八宿：", this.xiu));

        String xunKong = this.xunKongYear + " " + this.xunKongMonth + " " + this.xunKongDay + " " + this.xunKongHour;
        list.add(BaseInfoItemVO.build("空亡(年月日时)：", xunKong));
        list.add(BaseInfoItemVO.build("命宫：", this.mingGong));
        list.add(BaseInfoItemVO.build("身宫：", this.shenGong));
        list.add(BaseInfoItemVO.build("胎元：", this.taiYuan));
        list.add(BaseInfoItemVO.build("胎元：", this.taiYuan));
        this.setInfoList(list);
    }
}
