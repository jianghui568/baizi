package com.yibuyiju.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/14 17:42
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CalendarEnum {
    SOLAR(1, "阳历"),
    LUNAR(2, "阴历");

    private Integer value;
    private String text;

    private CalendarEnum(Integer value, String description) {
        this.value = value;
        this.text = description;
    }

    public static boolean contain(CalendarEnum e) {
        CalendarEnum[] types = CalendarEnum.values();
        Optional<CalendarEnum> exist = Arrays.stream(types).filter(item -> item.equals(e)).findFirst();
        return exist.isPresent();
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CalendarEnum getByValue(Integer value) {
        if (Objects.isNull(value)) {
            return null;
        }
        for (CalendarEnum e : CalendarEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}
