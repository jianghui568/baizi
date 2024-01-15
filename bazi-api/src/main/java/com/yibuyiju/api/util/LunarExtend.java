package com.yibuyiju.api.util;

import cn.hutool.core.util.ArrayUtil;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.util.LunarUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/15 15:08
 */

public class LunarExtend {

    private Lunar lunar;

    private Map<String, Integer> diZhiNumMap = new HashMap<String, Integer>() {{

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

    LunarExtend(Lunar lunar) {
        this.lunar = lunar;
    }

    public static LunarExtend fromLunar(Lunar lunar) {
        return new LunarExtend(lunar);
    }

    public Lunar getLunar() {
        return this.lunar;
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzA4ODcyODgzNw==&mid=2651479692&idx=8&sn=823470f717afae8426ced593049f545b&chksm=8bdb4ae6bcacc3f0bae4edd4d0ea4fa451d3839adac0a2ba01d0c226fc369af0c7e59bbabd7a&scene=27
     * <p>
     * https://wenku.baidu.com/view/4054294ce518964bcf847cb2?aggId=54dff8b464ec102de2bd960590c69ec3d4bbdb54&fr=catalogMain_text_ernie_recall_backup_new%3Awk_recommend_main3&_wkts_=1705304917300&bdQuery=%E5%85%AB%E5%AD%97%E5%91%BD%E5%AE%AB%E6%9F%A5%E8%AF%A2%E8%A1%A8
     *
     * @return
     */
    public String getMingGong() {
        Integer month = diZhiNumMap.get(this.lunar.getEightChar().getMonthZhi());
        Integer hour = diZhiNumMap.get(this.lunar.getEightChar().getTimeZhi());

        Integer mh = month + hour;
        Integer benWei = 14;
        if (mh > 14) {
            benWei = 26;
        }
        Integer gongZhi = benWei - mh;

        Optional<String> foundKey = diZhiNumMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(gongZhi))
                .map(Map.Entry::getKey)
                .findFirst();

        if (foundKey.isPresent()) {
            return foundKey.get();
        }
        return "";
    }

    public String getShenGong() {
        return "寅";

    }

    /**
     * 1、生月干向前推一干，为支
     * 2、生月支向前推三支，为干
     *
     * @return
     */
    public String getTaiYuan() {
        Integer monthGanIndex = ArrayUtil.indexOf(LunarUtil.GAN, this.lunar.getEightChar().getMonthGan());
        Integer monthZhiIndex = ArrayUtil.indexOf(LunarUtil.ZHI, this.lunar.getEightChar().getMonthZhi());

        Integer taiYuanGanIndex = monthZhiIndex + 3;
        Integer taiYuanZhiIndex = monthGanIndex + 1;
        if (taiYuanGanIndex > 10) {
            taiYuanGanIndex = taiYuanGanIndex - 10;
        }
        if (taiYuanZhiIndex > 12) {
            taiYuanZhiIndex = taiYuanZhiIndex - 12;
        }

        return LunarUtil.GAN[taiYuanGanIndex] + LunarUtil.ZHI[taiYuanZhiIndex];
    }
}
