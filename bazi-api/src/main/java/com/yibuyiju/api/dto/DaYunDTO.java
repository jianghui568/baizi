package com.yibuyiju.api.dto;

import com.nlf.calendar.eightchar.DaYun;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/28 15:38
 */
@Data
@Accessors(chain = true)
public class DaYunDTO {

    private Integer startYear;
    private Integer endYear;
    private Integer startAge;
    private Integer endAge;
    private String solar;
    private List<String> shiShenList;
    private List<String> yearGanZhiList;
    private List<String> ageList;
    private List<String> yearList;


    public static DaYunDTO fromDaYun(DaYun daYun) {
        DaYunDTO da = new DaYunDTO();
        da.setStartYear(daYun.getStartYear())
                .setEndYear(daYun.getEndYear())
                .setStartAge(daYun.getStartAge())
                .setEndAge(daYun.getEndAge());

        return da;
    }
}
