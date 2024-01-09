package com.yibuyiju.common.threadlocal;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/9 15:37
 */
public interface ILoginUser {
    long getId();

    String getUsername();

    String getPhone();

    List<String> getRoles();

    List<String> getPermissions();
}
