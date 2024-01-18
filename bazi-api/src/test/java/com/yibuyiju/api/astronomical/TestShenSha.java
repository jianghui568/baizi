package com.yibuyiju.api.astronomical;

import cn.hutool.core.date.DateUtil;
import com.nlf.calendar.Lunar;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:12
 */
public class TestShenSha {

    @Test
    public void testShen() {

        Lunar d = Lunar.fromDate(DateUtil.parse("1989-12-05 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        // 吉神宜趋
        List<String> l = d.getDayJiShen();
        for (int i = 0, j = l.size(); i < j; i++) {
            System.err.println(l.get(i));
        }
        System.err.println("==================");
        // 凶煞宜忌
        l = d.getDayXiongSha();
        for (int i = 0, j = l.size(); i < j; i++) {
            System.err.println(l.get(i));
        }
    }
}
