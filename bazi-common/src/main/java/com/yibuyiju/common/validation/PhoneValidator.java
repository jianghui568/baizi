package com.yibuyiju.common.validation;

import cn.hutool.core.lang.Validator;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/17 14:14
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.isEmpty(phone)) {
            return false;
        }

        return Validator.isMobile(phone);
    }
}
