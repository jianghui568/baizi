package com.yibuyiju.api.service;

import com.nlf.calendar.Lunar;
import com.yibuyiju.api.dto.PredictInfoDTO;
import com.yibuyiju.api.dto.TesterInfoDTO;
import com.yibuyiju.api.enums.CalendarEnum;
import com.yibuyiju.api.util.Helps;
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

    public PredictInfoDTO baziInfo(TesterInfoDTO testerInfoDTO) {

        if (!CalendarEnum.contain(testerInfoDTO.getCalendarType())) {
            throw new VerifyBizException("日历类型错误！");
        }

        Lunar lunar;

        // 阳历
        if (testerInfoDTO.getCalendarType().equals(CalendarEnum.SOLAR)) {
            lunar = Lunar.fromDate(Helps.localDateTimeToDate(testerInfoDTO.getBirthday()));
        } else {
            lunar = Lunar.fromYmdHms(
                    testerInfoDTO.getBirthday().getYear(),
                    testerInfoDTO.getBirthday().getMonthValue(),
                    testerInfoDTO.getBirthday().getDayOfMonth(),
                    testerInfoDTO.getBirthday().getHour(),
                    testerInfoDTO.getBirthday().getMinute(),
                    0
            );
        }

        return PredictInfoDTO.fromLunar(lunar, testerInfoDTO.getGender());
    }
}
