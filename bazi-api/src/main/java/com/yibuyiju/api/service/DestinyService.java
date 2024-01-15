package com.yibuyiju.api.service;

import com.nlf.calendar.Lunar;
import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.enums.CalendarEnum;
import com.yibuyiju.api.util.Helps;
import com.yibuyiju.api.util.LunarExtend;
import com.yibuyiju.api.vo.PredictInfoVO;
import com.yibuyiju.common.exception.VerifyBizException;
import org.springframework.stereotype.Service;

/**
 * https://6tail.cn/calendar/api.html
 *
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 14:41
 */
@Service
public class DestinyService {

    public PredictInfoVO baziInfo(TesterDTO tester) {

        if (!CalendarEnum.contain(tester.getCalendarType())) {
            throw new VerifyBizException("日历类型错误！");
        }

        Lunar lunar;
        // 阳历
        if (tester.getCalendarType().equals(CalendarEnum.SOLAR)) {
            lunar = Lunar.fromDate(Helps.localDateTimeToDate(tester.getBirthday()));
        } else {
            lunar = Lunar.fromYmdHms(
                    tester.getBirthday().getYear(),
                    tester.getBirthday().getMonthValue(),
                    tester.getBirthday().getDayOfMonth(),
                    tester.getBirthday().getHour(),
                    tester.getBirthday().getMinute(),
                    0
            );
        }

        return PredictInfoVO.fromLunar(LunarExtend.fromLunar(lunar), tester);
    }
}
