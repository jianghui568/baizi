package com.yibuyiju.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yibuyiju.api.entity.UserEntity;

/**
 * @author yjh
 * @since 2023-12-06
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    int hahaUser(UserEntity userEntity);

}
