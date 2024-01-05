package com.yibuyiju.api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yibuyiju.api.dto.UserDTO;
import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.api.mapper.UserMapper;
import com.yibuyiju.api.mapstruct.UserConverter;
import com.yibuyiju.common.exception.VerifyBizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 16:58
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 注册
     *
     * @param userDTO
     * @return
     */
    public long login(UserDTO userDTO) {
        UserEntity userEntity = UserConverter.INSTANCE.toEntity(userDTO);
        LambdaQueryWrapper<UserEntity> lambda = new LambdaQueryWrapper<>();
        lambda.eq(UserEntity::getPhone, userEntity.getPhone());

        UserEntity user = userMapper.selectOne(lambda);
        if (Objects.nonNull(user)) {
            throw new VerifyBizException("手机号已存在，请更换手机号重新注册");
        }
        userMapper.insert(userEntity);
        if (Objects.isNull(userEntity.getId()) || userEntity.getId() <= 0) {
            throw new VerifyBizException("注册失败！！！");
        }
        return userEntity.getId();
    }
}

