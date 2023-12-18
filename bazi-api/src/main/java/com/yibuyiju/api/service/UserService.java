package com.yibuyiju.api.service;

import com.yibuyiju.api.dto.UserInfoDTO;
import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.api.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 16:58
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void saveUser(UserInfoDTO userInfoDTO) {
        UserEntity userEntity = new UserEntity();
        // BeanUtils.copyProperties(userInfoDTO, userEntity);
        userEntity.username(userInfoDTO.username());
        userMapper.hahaUser(userEntity);
    }
}

