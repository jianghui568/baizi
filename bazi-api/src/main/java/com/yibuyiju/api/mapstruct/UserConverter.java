package com.yibuyiju.api.mapstruct;

import com.yibuyiju.api.dto.UserDTO;
import com.yibuyiju.api.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/4 15:34
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserEntity toEntity(UserDTO user);
}
