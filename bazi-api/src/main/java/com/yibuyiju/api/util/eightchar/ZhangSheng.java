package com.yibuyiju.api.util.eightchar;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:04
 */
final public class ZhangSheng {
    public static String[] LIST = {"长生", "沐浴", "冠带", "临官", "帝旺", "衰", "病", "死", "墓", "绝", "胎", "养",};

    public static Map<String, String[]> BIAO = new HashMap<String, String[]>() {{
        put("甲", new String[]{"亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌",});
        put("乙", new String[]{"午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未",});
        put("丙", new String[]{"寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑",});
        put("丁", new String[]{"酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌",});
        put("戊", new String[]{"寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑",});
        put("己", new String[]{"酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌",});
        put("庚", new String[]{"巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰",});
        put("辛", new String[]{"子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑",});
        put("壬", new String[]{"申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未",});
        put("癸", new String[]{"卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰",});

    }};


    public static String getZhangSheng(String gan, String zhi) {
        if (StringUtils.isEmpty(gan)) {
            return "";
        }
        String[] list = ZhangSheng.BIAO.get(gan);
        if (Objects.isNull(list) || list.length == 0) {
            return "";
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(zhi)) {
                return ZhangSheng.LIST[i];
            }
        }
        return "";
    }
}
