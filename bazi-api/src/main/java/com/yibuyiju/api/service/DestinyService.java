package com.yibuyiju.api.service;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import com.yibuyiju.api.dto.PredictInfoDTO;
import com.yibuyiju.api.dto.TesterInfoDTO;
import com.yibuyiju.api.enums.CalendarEnum;
import com.yibuyiju.api.util.Helps;
import com.yibuyiju.common.exception.VerifyBizException;
import org.springframework.stereotype.Service;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 14:41
 */
@Service
public class DestinyService {

    public PredictInfoDTO baziInfo(TesterInfoDTO testerInfoDTO) {

        if (!CalendarEnum.hasValue(testerInfoDTO.calendarType().getValue())) {
            throw new VerifyBizException("日历类型错误！");
        }

        Lunar lunar = Lunar.fromDate(Helps.localDateTimeToDate(testerInfoDTO.birthday()));
        // 阳历
        if (testerInfoDTO.calendarType().equals(CalendarEnum.SOLAR)) {
            Solar solar = Solar.fromDate(Helps.localDateTimeToDate(testerInfoDTO.birthday()));
            lunar = solar.getLunar();
        }

        PredictInfoDTO predictInfo = PredictInfoDTO.fromLunar(lunar);

        return predictInfo;
    }
}
