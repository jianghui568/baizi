package com.yibuyiju.api.util.eightchar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/18 14:59
 */
public class ConfigBiao {

    /**
     * 长生
     */
    public static Map<String, Integer> ZHI_NUM_MAP = new HashMap<String, Integer>() {{

        put("寅", 1);
        put("卯", 2);
        put("辰", 3);
        put("巳", 4);
        put("午", 5);
        put("未", 6);
        put("申", 7);
        put("酉", 8);
        put("戌", 9);
        put("亥", 10);
        put("子", 11);
        put("丑", 12);
    }};
    public static String[] ZHANGSHENG_LIST = {"长生", "沐浴", "冠带", "临官", "帝旺", "衰", "病", "死", "墓", "绝", "胎", "养",};

    public static Map<String, String[]> ZHANGSHENG = new HashMap<String, String[]>() {{
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


    /**
     * 神煞查法
     * https://www.smxs.com/mingli/bzzs_bzsm/133323.html
     */
    /**
     * 一、天干查法
     * 1、 此查法中天干以年、日干为主，地支为年月日时之地支，比如甲年、日生人地支见巳为文昌星；见子为太极贵人、福星贵人，其余类推。
     * 2、 天乙贵人的查法有两种，第一查法的歌诀为：“甲戊兼牛羊，乙己鼠猴乡，丙丁猪鸡位，壬癸兔蛇藏，庚辛逢马虎，此是贵人方”；第二查法的歌诀为：“甲戊庚牛羊，乙己鼠猴乡，丙丁猪鸡位，壬癸兔蛇藏，六辛逢马虎，此是贵人方，命中如遇此，定作紫微郎”。此处用的是第一个方法。
     */
    public static String[] SHENSHA_GAN_LIST = {"天乙贵人", "太极贵人", "文昌星", "金舆", "十干禄神", "国印贵人", "羊刃", "福星贵人",};
    public static Map<String, String[][]> SHENSHA_GAN = new HashMap<String, String[][]>() {{
        put("甲", new String[][]{
                new String[]{"丑", "未"},
                new String[]{"子", "午"},
                new String[]{"巳"},
                new String[]{"辰"},
                new String[]{"寅"},
                new String[]{"戌"},
                new String[]{"卯"},
                new String[]{"寅", "子"},
        });
        put("乙", new String[][]{
                new String[]{"子", "申"},
                new String[]{"子", "午"},
                new String[]{"午"},
                new String[]{"巳"},
                new String[]{"卯"},
                new String[]{"亥"},
                new String[]{"寅"},
                new String[]{"卯", "丑"},
        });

        put("丙", new String[][]{
                new String[]{"亥", "酉"},
                new String[]{"卯", "酉"},
                new String[]{"申"},
                new String[]{"未"},
                new String[]{"巳"},
                new String[]{"丑"},
                new String[]{"午"},
                new String[]{"寅", "子"},
        });
        put("丁", new String[][]{
                new String[]{"亥", "酉"},
                new String[]{"卯", "酉"},
                new String[]{"酉"},
                new String[]{"申"},
                new String[]{"午"},
                new String[]{"寅"},
                new String[]{"巳"},
                new String[]{"亥"},
        });
        put("戊", new String[][]{
                new String[]{"申", "未"},
                new String[]{"辰", "戌", "丑", "未"},
                new String[]{"申"},
                new String[]{"未"},
                new String[]{"巳"},
                new String[]{"丑"},
                new String[]{"午"},
                new String[]{"申"},
        });
        put("己", new String[][]{
                new String[]{"子", "申"},
                new String[]{"辰", "戌", "丑", "未"},
                new String[]{"酉"},
                new String[]{"申"},
                new String[]{"午"},
                new String[]{"寅"},
                new String[]{"巳"},
                new String[]{"未"},
        });
        put("庚", new String[][]{
                new String[]{"午", "寅"},
                new String[]{"寅", "亥"},
                new String[]{"亥"},
                new String[]{"戌"},
                new String[]{"申"},
                new String[]{"辰"},
                new String[]{"酉"},
                new String[]{"午"},
        });
        put("辛", new String[][]{
                new String[]{"午", "寅"},
                new String[]{"寅", "亥"},
                new String[]{"子"},
                new String[]{"亥"},
                new String[]{"酉"},
                new String[]{"巳"},
                new String[]{"申"},
                new String[]{"巳"},
        });
        put("壬", new String[][]{
                new String[]{"卯", "巳"},
                new String[]{"巳", "申"},
                new String[]{"寅"},
                new String[]{"丑"},
                new String[]{"亥"},
                new String[]{"未"},
                new String[]{"子"},
                new String[]{"辰"},
        });
        put("癸", new String[][]{
                new String[]{"卯", "巳"},
                new String[]{"巳", "申"},
                new String[]{"卯"},
                new String[]{"寅"},
                new String[]{"子"},
                new String[]{"申"},
                new String[]{"亥"},
                new String[]{"卯", "丑"},
        });
    }};

    /**
     * 二、月支查法
     * 1、 此查法以月支为主，比如寅月生人天干见丙为命带月德贵人、德秀贵人，年、日、时支见子为命带阴注阳受，以此类推。
     * 2、 若命无天德贵人、月德贵人，但有天德合、月德合，我们可看作为命带天德贵人、月德贵人。
     */
    public static String[] SHENSHA_MONTH_LIST = {"天德贵人", "天德合",
            "月德贵人",
            "月德合",
            "德秀贵人(德)",
            "德秀贵人(秀)",
            "天医",
            "阴注阳受",
    };
    public static Map<String, String[][]> SHENSHA_MONTH = new HashMap<String, String[][]>() {{
        put("寅", new String[][]{{"丁"}, {"壬"}, {"丙"}, {"辛"}, {"丙", "丁"}, {"戊", "癸"}, {"丑"}, {"子"},});
        put("卯", new String[][]{{"申"}, {"巳"}, {"甲"}, {"己"}, {"甲", "乙"}, {"丁", "壬"}, {"寅"}, {"亥"},});
        put("辰", new String[][]{{"壬"}, {"丁"}, {"壬"}, {"丁"}, {"壬", "癸", "戊", "己"}, {"丙", "辛", "甲", "己"}, {"卯"}, {"戌"},});
        put("巳", new String[][]{{"辛"}, {"丙"}, {"庚"}, {"乙"}, {"庚", "辛"}, {"乙", "庚"}, {"辰"}, {"酉"},});
        put("午", new String[][]{{"亥"}, {"寅"}, {"丙"}, {"辛"}, {"丙", "丁"}, {"戊", "癸"}, {"巳"}, {"戌"},});
        put("未", new String[][]{{"甲"}, {"己"}, {"甲"}, {"己"}, {"甲", "乙"}, {"丁", "壬"}, {"午"}, {"亥"},});
        put("申", new String[][]{{"癸"}, {"戊"}, {"壬"}, {"丁"}, {"壬", "癸", "戊", "己"}, {"丙", "辛", "甲", "己"}, {"未"}, {"子"},});
        put("酉", new String[][]{{"寅"}, {"亥"}, {"庚"}, {"乙"}, {"庚", "辛"}, {"乙", "庚"}, {"申"}, {"丑"},});
        put("戌", new String[][]{{"丙"}, {"辛"}, {"丙"}, {"辛"}, {"丙", "丁"}, {"戊", "癸"}, {"酉"}, {"寅"},});
        put("亥", new String[][]{{"乙"}, {"庚"}, {"甲"}, {"己"}, {"甲", "乙"}, {"丁", "壬"}, {"戌"}, {"卯"},});
        put("子", new String[][]{{"己"}, {"申"}, {"壬"}, {"丁"}, {"壬", "癸", "戊", "己"}, {"丙", "辛", "甲", "己"}, {"亥"}, {"寅"},});
        put("丑", new String[][]{{"庚"}, {"乙"}, {"庚"}, {"乙"}, {"庚", "辛"}, {"乙", "庚"}, {"子"}, {"丑"},});
    }};

    /**
     * 三、年、日支查法
     * 1、 此查法以年支和日支为主，比如年支为子，月日时支见寅则命带孤辰、驿马、丧门等神煞，如果日支为子，年月时支见卯则命带六厄煞。
     * 2、  “天罗地网”神煞比较独特，戌、亥或者辰、巳互见才算天罗或者地网，其他地支不算。
     * 3、  “丧门吊客”只能以年柱为主，日柱不算。
     */
    public static String[] SHENSHA_ZHI_LIST = {"六厄", "孤辰", "寡宿", "咸池", "亡神", "劫煞", "天罗", "地网", "灾煞", "驿马", "华盖", "将星", "丧门", "吊客",};
    public static Map<String, String[]> SHENSHA_ZHI = new HashMap<String, String[]>() {{
        put("子", new String[]{"卯", "寅", "戌", "酉", "亥", "巳", "", "", "午", "寅", "辰", "子", "寅", "戌"});
        put("丑", new String[]{"子", "寅", "戌", "午", "申", "寅", "", "", "卯", "亥", "丑", "酉", "卯", "亥"});
        put("寅", new String[]{"酉", "巳", "丑", "卯", "巳", "亥", "", "", "子", "申", "戌", "午", "辰", "子"});
        put("卯", new String[]{"午", "巳", "丑", "子", "寅", "申", "", "", "酉", "巳", "未", "卯", "巳", "丑"});
        put("辰", new String[]{"卯", "巳", "丑", "酉", "亥", "巳", "", "巳", "午", "寅", "辰", "子", "午", "寅"});
        put("巳", new String[]{"子", "申", "辰", "午", "申", "寅", "", "辰", "卯", "亥", "丑", "酉", "未", "卯"});
        put("午", new String[]{"酉", "申", "辰", "卯", "巳", "亥", "", "", "子", "申", "戌", "午", "申", "辰"});
        put("未", new String[]{"午", "申", "辰", "子", "寅", "申", "", "", "酉", "巳", "未", "卯", "酉", "巳"});
        put("申", new String[]{"卯", "亥", "未", "酉", "亥", "巳", "", "", "午", "寅", "辰", "子", "戌", "午"});
        put("酉", new String[]{"子", "亥", "未", "午", "申", "寅", "", "", "卯", "亥", "丑", "酉", "亥", "未"});
        put("戌", new String[]{"酉", "亥", "未", "卯", "巳", "亥", "亥", "", "子", "申", "戌", "午", "子", "申"});
        put("亥", new String[]{"午", "寅", "戌", "子", "寅", "申", "戌", "", "酉", "巳", "未", "卯", "丑", "酉"});
    }};
    /**
     * SHENSHA_GENDER_MAN 男女分别看（阳男阴女）
     * SHENSHA_GENDER_WOMEN 男女分别看（阴男阳女）
     * 此查法以年支为主，比如甲子年生男日月时支见卯为身带勾煞，见酉则身带绞煞；反而甲子年生女日月时见卯为身带绞煞，见酉则身带勾煞，以此类推。
     */
    public static String[] SHENSHA_GENDER_LIST = {"勾煞", "绞煞", "元辰"};
    public static Map<String, String[]> SHENSHA_GENDER_MAN = new HashMap<String, String[]>() {{
        put("子", new String[]{"卯", "酉", "未"});
        put("丑", new String[]{"辰", "戌", "申"});
        put("寅", new String[]{"巳", "亥", "酉"});
        put("卯", new String[]{"午", "子", "戌"});
        put("辰", new String[]{"未", "丑", "亥"});
        put("巳", new String[]{"申", "寅", "子"});
        put("午", new String[]{"酉", "卯", "丑"});
        put("未", new String[]{"戌", "辰", "寅"});
        put("申", new String[]{"亥", "巳", "卯"});
        put("酉", new String[]{"子", "午", "辰"});
        put("戌", new String[]{"丑", "未", "巳"});
        put("亥", new String[]{"寅", "申", "午"});
    }};
    public static Map<String, String[]> SHENSHA_GENDER_WOMEN = new HashMap<String, String[]>() {{
        put("子", new String[]{"酉", "卯", "巳"});
        put("丑", new String[]{"戌", "辰", "午"});
        put("寅", new String[]{"亥", "巳", "未"});
        put("卯", new String[]{"子", "午", "申"});
        put("辰", new String[]{"丑", "未", "酉"});
        put("巳", new String[]{"寅", "申", "戌"});
        put("午", new String[]{"卯", "酉", "亥"});
        put("未", new String[]{"辰", "戌", "子"});
        put("申", new String[]{"巳", "亥", "丑"});
        put("酉", new String[]{"午", "子", "寅"});
        put("戌", new String[]{"未", "丑", "卯"});
        put("亥", new String[]{"申", "寅", "辰"});
    }};


}
