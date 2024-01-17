package com.yibuyiju.api.vo.destiny;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 15:49
 */
@Accessors(chain = true)
@Data
public class ZhuInfoVO {
    String gan;
    String ganShiShen;
    String zhi;
    String diShi;
    List<String> cang;
    List<String> zhiShiShen;

    String xunKong;
    String zhangSheng;
    String naYin;
}
