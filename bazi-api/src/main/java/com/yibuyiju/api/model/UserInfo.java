package com.yibuyiju.api.model;

import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.common.threadlocal.ILoginUser;
import lombok.Data;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/9 15:45
 */
@Data
public class UserInfo implements ILoginUser {

    protected UserEntity user;

    @Override
    public long getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getPhone() {
        return user.getPhone();
    }

    @Override
    public List<String> getRoles() {
        return null;
    }

    @Override
    public List<String> getPermissions() {
        return null;
    }
}
