package com.yibuyiju.common.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/17 14:14
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password password) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }

        return containsLetterAndDigit(password);
    }

    /**
     * 检查密码中是否包含至少一个字母和一个数字
     *
     * @param password
     * @return
     */
    private boolean containsLetterAndDigit(String password) {
        boolean containsLetter = false;
        boolean containsDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                containsLetter = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            }

            // 如果已经包含字母和数字，则可以退出循环
            if (containsLetter && containsDigit) {
                break;
            }
        }
        // 返回是否同时包含字母和数字
        return containsLetter && containsDigit;
    }
}
