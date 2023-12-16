package com.yibuyiju.api.astronomical;

import cn.hutool.core.date.DateUtil;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 11:15
 */
public class TestSolarTime {

    @Test
    public void testZty() {

        Date date = DateUtil.parse("2023-12-16 11:2:50", "yyyy-MM-dd HH:mm:ss");
        Solar s = Solar.fromDate(date);

        double rulueri = s.getJulianDay();
        System.err.println(date.toString());
        System.err.println(rulueri);

        Lunar lunar = s.getLunar();
        // System.err.println(lunar.get);
    }
}
