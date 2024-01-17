package com.yibuyiju.api.astronomical;

import com.yibuyiju.api.util.eightchar.ZhangSheng;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:12
 */
public class TestZhangSheng {

    @Test
    public void testZhangSheng() {

        String res = ZhangSheng.getZhangSheng("甲", "子");
        Assert.isTrue(res.equals("沐浴"), "甲在子， except : 沐浴" + "; but got:" + res);

        res = ZhangSheng.getZhangSheng("丙", "巳");
        Assert.isTrue(res.equals("临官"), "丙在巳， except : 临官" + "; but got:" + res);

        res = ZhangSheng.getZhangSheng("丙", "狗");
        Assert.isTrue(res.equals(""), "丙在巳， except :  " + "; but got:" + res);
    }
}
