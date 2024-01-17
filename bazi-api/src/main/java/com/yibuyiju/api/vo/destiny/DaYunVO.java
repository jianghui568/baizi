package com.yibuyiju.api.vo.destiny;

import com.nlf.calendar.eightchar.DaYun;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class DaYunVO {
    private Integer startYear;
    private Integer endYear;
    private Integer startAge;
    private Integer endAge;
    private String solar;
    private String ganZhi;
    private List<LiuYearVO> liuYearList;


    public static DaYunVO fromDaYun(DaYun daYun) {

        DaYunVO da = new DaYunVO();
        da.setStartYear(daYun.getStartYear())
                .setEndYear(daYun.getEndYear())
                .setStartAge(daYun.getStartAge())
                .setEndAge(daYun.getEndAge())
                .setGanZhi(daYun.getGanZhi());

        List<LiuYearVO> list = new ArrayList<>();
        Arrays.stream(daYun.getLiuNian())
                .forEach(item -> {
                    list.add(LiuYearVO.fromLunar(item));
                });

        da.setLiuYearList(list);
        return da;
    }
}
