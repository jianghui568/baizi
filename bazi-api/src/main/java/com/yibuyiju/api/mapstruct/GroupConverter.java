package com.yibuyiju.api.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yibuyiju.api.dto.GroupDTO;
import com.yibuyiju.api.entity.UserGroupEntity;
import com.yibuyiju.api.vo.GroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/4 15:34
 */
@Mapper
public interface GroupConverter {

    GroupConverter INSTANCE = Mappers.getMapper(GroupConverter.class);

    UserGroupEntity toEntity(GroupDTO group);

    GroupVO toVO(UserGroupEntity group);

    List<GroupVO> toListVO(List<UserGroupEntity> groups);

    default IPage<GroupVO> toPage(IPage<UserGroupEntity> list) {
        IPage<GroupVO> result = new Page<>();
        result.setPages(list.getPages());
        result.setCurrent(list.getCurrent());
        result.setSize(list.getSize());
        result.setTotal(list.getTotal());
        result.setRecords(toListVO(list.getRecords()));
        return result;
    }
}
