package com.yibuyiju.api.service;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yibuyiju.api.dto.LoginDTO;
import com.yibuyiju.api.dto.UserDTO;
import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.api.mapper.UserMapper;
import com.yibuyiju.api.mapstruct.UserConverter;
import com.yibuyiju.api.model.TokenInfo;
import com.yibuyiju.common.exception.VerifyBizException;
import com.yibuyiju.common.util.jwt.JwtUtil;
import com.yibuyiju.common.util.jwt.PayloadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 16:58
 */

@Service
public class UserService {

    @Value("${token.expires-hour}")
    private int tokenExpiredHour;


    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param userDTO
     * @return
     */
    public long register(UserDTO userDTO) {
        UserEntity userEntity = UserConverter.INSTANCE.toEntity(userDTO);
        LambdaQueryWrapper<UserEntity> lambda = new LambdaQueryWrapper<>();
        lambda.eq(UserEntity::getPhone, userEntity.getPhone());

        UserEntity user = userMapper.selectOne(lambda);
        if (Objects.nonNull(user)) {
            throw new VerifyBizException("手机号已存在，请更换手机号重新注册");
        }

        userEntity.setPassword(SecureUtil.sha1(userEntity.getPassword()));
        userMapper.insert(userEntity);
        if (Objects.isNull(userEntity.getId()) || userEntity.getId() <= 0) {
            throw new VerifyBizException("注册失败！！！");
        }
        return userEntity.getId();
    }

    public TokenInfo login(LoginDTO loginDTO) {
        LambdaQueryWrapper<UserEntity> lambda = new LambdaQueryWrapper<>();
        lambda.eq(UserEntity::getPhone, loginDTO.getPhone());

        UserEntity user = userMapper.selectOne(lambda);
        if (Objects.isNull(user)) {
            throw new VerifyBizException("用户名或密码错误！");
        }
        if (!user.getPassword().equals(SecureUtil.sha1(loginDTO.getPassword()))) {
            throw new VerifyBizException("用户名或密码错误！");
        }

        PayloadDTO payloadDTO = JwtUtil.generatePayload(user.getId(), tokenExpiredHour * 60 * 60);

        String token = JwtUtil.generateToken(payloadDTO);
        return TokenInfo.generateJwtToken(token, payloadDTO.getExp());
    }

    public UserEntity getByUserId(Long id) {
        return userMapper.selectById(id);
    }
}

