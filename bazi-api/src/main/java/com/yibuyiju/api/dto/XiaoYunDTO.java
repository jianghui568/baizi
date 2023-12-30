package com.yibuyiju.api.dto;

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
public class XiaoYunDTO {
    private Integer startYear;
    private Integer endYear;
    private Integer startAge;
    private Integer endAge;
    private String solar;
    private String ganZhi;
    private List<LiuYearDTO> liuYearList;


    public static XiaoYunDTO fromDaYun(DaYun daYun) {
        XiaoYunDTO da = new XiaoYunDTO();
        da.setStartYear(daYun.getStartYear())
                .setEndYear(daYun.getEndYear())
                .setStartAge(daYun.getStartAge())
                .setEndAge(daYun.getEndAge())
                .setGanZhi(daYun.getGanZhi());

        List<LiuYearDTO> list = new ArrayList<>();
        Arrays.stream(daYun.getLiuNian())
                .forEach(item -> {
                    list.add(LiuYearDTO.fromLunar(item));
                });

        da.setLiuYearList(list);
        return da;
    }
}
