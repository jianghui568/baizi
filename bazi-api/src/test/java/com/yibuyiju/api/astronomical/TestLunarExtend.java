package com.yibuyiju.api.astronomical;

import com.nlf.calendar.Lunar;
import com.yibuyiju.api.util.eightchar.LunarExtend;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:12
 */
public class TestLunarExtend {

    @Test
    public void testZhangSheng() {


        LunarExtend lunar = new LunarExtend(null);

        String res = lunar.getZhangSheng("甲", "子");
        Assert.isTrue(res.equals("沐浴"), "甲在子， except : 沐浴" + "; but got:" + res);

        res = lunar.getZhangSheng("丙", "巳");
        Assert.isTrue(res.equals("临官"), "丙在巳， except : 临官" + "; but got:" + res);

        res = lunar.getZhangSheng("丙", "狗");
        Assert.isTrue(res.equals(""), "丙在巳， except :  " + "; but got:" + res);
    }

    @Test
    public void testShenSha() {
        Lunar l = Lunar.fromYmdHms(1987, 9, 15, 5, 30, 0);
        LunarExtend lunar = LunarExtend.fromLunar(l);

        String ygan = lunar.getLunar().getYearGan();
        String yzhi = lunar.getLunar().getYearZhi();
        String mgan = lunar.getLunar().getMonthGan();
        String mzhi = lunar.getLunar().getMonthZhi();
        String dgan = lunar.getLunar().getDayGan();
        String dzhi = lunar.getLunar().getDayZhi();
        String hgan = lunar.getLunar().getTimeGan();
        String hzhi = lunar.getLunar().getTimeZhi();

        System.err.println("Year:" + ygan + yzhi);
        System.err.println("Month:" + mgan + mzhi);
        System.err.println("Day:" + dgan + dzhi);
        System.err.println("Hour:" + hgan + hzhi);


        List<String> year = lunar.getShenShaYear();
        System.err.println("Year Shen:" + year.toString());
    }
}
