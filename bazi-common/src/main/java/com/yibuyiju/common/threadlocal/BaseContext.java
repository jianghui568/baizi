package com.yibuyiju.common.threadlocal;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 17:02
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
