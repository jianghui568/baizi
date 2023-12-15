package com.yibuyiju.api.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 14:43
 */
public final class GanzhiConstants {
    private GanzhiConstants() {
    }

    public static final String[] GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    public static final String[] ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    public static final Map<String, String> ZHI_HOURS = new HashMap<String, String>() {{
        put("子", "23-1");
        put("丑", "1-3");
        put("寅", "3-5");
        put("卯", "5-7");
        put("辰", "7-9");
        put("巳", "9-11");
        put("午", "11-13");
        put("未", "13-15");
        put("申", "15-17");
        put("酉", "17-19");
        put("戌", "19-21");
        put("亥", "21-23");
    }};
}
