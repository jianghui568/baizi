package com.yibuyiju.common.threadlocal;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:02
 */
public class BaseContext {
    private static ThreadLocal<ILoginUser> threadUser = new ThreadLocal<>();

    public static void setLoginUser(ILoginUser user) {
        threadUser.set(user);
    }

    public static ILoginUser getLoginUser() {
        return threadUser.get();
    }
}
