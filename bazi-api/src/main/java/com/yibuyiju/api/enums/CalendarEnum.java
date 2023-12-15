package com.yibuyiju.api.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:42
 */
public enum CalendarEnum {
    SOLAR(1, "阳历"),
    LUNAR(2, "阴历");

    private Integer value;
    private String text;

    private CalendarEnum(Integer value, String description) {
        this.value = value;
        this.text = description;
    }

    public String getText() {
        return this.text;
    }

    public Integer getValue() {
        return this.value;
    }


    public static Boolean hasValue(Integer val) {
        CalendarEnum[] types = CalendarEnum.values();
        Optional<CalendarEnum> exist = Arrays.stream(types).filter(item -> item.getValue().equals(val)).findFirst();
        return exist.isPresent();
    }

    public static List<EnumIntOption> toOptionArray() {
        List<EnumIntOption> list = new ArrayList<>();

        Arrays.stream(CalendarEnum.values()).forEach(item -> {
            EnumIntOption option = new EnumIntOption();
            list.add(option.text(item.getText()).value(item.getValue()));
        });
        return list;
    }
}
