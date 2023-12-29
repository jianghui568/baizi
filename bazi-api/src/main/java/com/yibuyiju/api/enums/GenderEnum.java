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
public enum GenderEnum {
    MAN(1, "男"),
    WOMEN(2, "女");

    private Integer value;
    private String text;

    private GenderEnum(Integer value, String description) {
        this.value = value;
        this.text = description;
    }

    public static Boolean contain(GenderEnum e) {
        GenderEnum[] types = GenderEnum.values();
        Optional<GenderEnum> exist = Arrays.stream(types).filter(item -> item.equals(e)).findFirst();
        return exist.isPresent();
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GenderEnum getByValue(Integer value) {
        if (Objects.isNull(value)) {
            return null;
        }
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.value.equals(value)) {
                return gender;
            }
        }
        return null;
    }

}
