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
public enum GenderEnum {
    UNKNOWN(0, "未知"),
    MAN(1, "男"),
    WOMEN(2, "女");

    private Integer value;
    private String text;

    private GenderEnum(Integer value, String description) {
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
        GenderEnum[] types = GenderEnum.values();
        Optional<GenderEnum> exist = Arrays.stream(types).filter(item -> item.getValue().equals(val)).findFirst();
        return exist.isPresent();
    }

    public static List<EnumIntOption> toOptionArray() {
        List<EnumIntOption> list = new ArrayList<>();

        Arrays.stream(GenderEnum.values()).forEach(item -> {
            EnumIntOption option = new EnumIntOption();
            list.add(option.text(item.getText()).value(item.getValue()));
        });
        return list;
    }
}
