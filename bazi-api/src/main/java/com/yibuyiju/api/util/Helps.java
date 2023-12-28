package com.yibuyiju.api.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/26 16:11
 */
public final class Helps {

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Helps.localDateTimeToDate(localDateTime, null);
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime
     * @param zoneId        如果为null, 采用系统默认时区
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = ZoneId.systemDefault();
        }
        // 将 LocalDateTime 转换为 java.util.Date 对象
        return Date.from(localDateTime.atZone(zoneId).toInstant());

    }


}
