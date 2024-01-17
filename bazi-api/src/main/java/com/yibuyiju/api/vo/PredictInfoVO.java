package com.yibuyiju.api.vo;

import com.nlf.calendar.EightChar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.eightchar.Yun;
import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.util.eightchar.LunarExtend;
import com.yibuyiju.api.vo.destiny.BaseInfoVO;
import com.yibuyiju.api.vo.destiny.DaYunVO;
import com.yibuyiju.api.vo.destiny.EightCharVO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private BaseInfoVO baseInfo;
    private EightCharVO eightChar;
    private List<DaYunVO> daYunList;

    public static PredictInfoVO fromLunar(LunarExtend lunarExtend, TesterDTO tester) {
        PredictInfoVO predictInfo = new PredictInfoVO();

        predictInfo.setBaseInfo(BaseInfoVO.fromLunar(lunarExtend, tester));

        Lunar lunar = lunarExtend.getLunar();
        EightChar eightChar = lunar.getEightChar();
        predictInfo.setEightChar(EightCharVO.fromEightChar(eightChar));

        Yun yun = eightChar.getYun(tester.getGender().getValue());
        predictInfo.setDaYunList(PredictInfoVO.makeDaYunList(yun));

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

}
