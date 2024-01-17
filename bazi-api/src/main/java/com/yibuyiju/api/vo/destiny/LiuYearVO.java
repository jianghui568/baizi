package com.yibuyiju.api.vo.destiny;

import com.nlf.calendar.eightchar.LiuNian;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class LiuYearVO {

    private Integer year;
    private Integer age;
    private String ganZhi;
    private String xun;
    private String xunKong;

    public static LiuYearVO fromLunar(LiuNian liuNian) {
        LiuYearVO nian = new LiuYearVO();
        nian.setYear(liuNian.getYear())
                .setAge(liuNian.getAge())
                .setGanZhi(liuNian.getGanZhi())
                .setXun(liuNian.getXun())
                .setXunKong(liuNian.getXunKong());
        return nian;
    }
}
