package com.yibuyiju.api.vo.destiny;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/17 14:49
 */
@Data
public class BaseInfoItemVO {
    private String title;
    private String content;

    public static BaseInfoItemVO build(String title, String content) {
        BaseInfoItemVO item = new BaseInfoItemVO();
        item.setTitle(StringUtils.isEmpty(title) ? "" : title);
        item.setContent(StringUtils.isEmpty(content) ? "" : content);
        return item;
    }
}
