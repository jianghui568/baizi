package com.yibuyiju.common.util;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/8 18:06
 */
public class Paging {

    public static int normalizeSize(int size) {
        int max = 100;
        int def = 10;
        if (size < 0) {
            return def;
        }
        if (size > max) {
            return max;
        }
        return size;
    }

    public static int normalizePage(int page) {

        if (page < 0) {
            return 1;
        }
        return page;
    }
}
