package com.yibuyiju.api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yibuyiju.api.dto.GroupDTO;
import com.yibuyiju.api.dto.GroupSearchDTO;
import com.yibuyiju.api.entity.UserGroupEntity;
import com.yibuyiju.api.mapper.GroupMapper;
import com.yibuyiju.api.mapstruct.GroupConverter;
import com.yibuyiju.api.vo.GroupVO;
import com.yibuyiju.common.exception.VerifyBizException;
import com.yibuyiju.common.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/16 16:58
 */

@Service
public class GroupService {

    @Autowired
    GroupMapper groupMapper;

    /**
     * 添加
     *
     * @param groupDTO
     * @return
     */
    public long add(GroupDTO groupDTO) {
        UserGroupEntity groupEntity = GroupConverter.INSTANCE.toEntity(groupDTO);
        LambdaQueryWrapper<UserGroupEntity> lambda = new LambdaQueryWrapper<>();
        lambda.eq(UserGroupEntity::getName, groupEntity.getName());

        UserGroupEntity exist = groupMapper.selectOne(lambda);
        if (Objects.nonNull(exist)) {
            throw new VerifyBizException("分组名称已经存在");
        }
        groupMapper.insert(groupEntity);
        if (Objects.isNull(groupEntity.getId()) || groupEntity.getId() <= 0) {
            throw new VerifyBizException("操作失败！！！");
        }
        return groupEntity.getId();
    }

    public void update(GroupDTO groupDTO) {
        UserGroupEntity groupEntity = GroupConverter.INSTANCE.toEntity(groupDTO);

        if (Objects.isNull(groupEntity.getId())) {
            throw new VerifyBizException("数据有误无id");
        }
        UserGroupEntity exist = groupMapper.selectById(groupDTO.getId());
        if (Objects.isNull(exist)) {
            throw new VerifyBizException("数据不存在");
        }
        LambdaQueryWrapper<UserGroupEntity> lambda = new LambdaQueryWrapper<>();
        lambda.eq(UserGroupEntity::getName, groupEntity.getName());
        groupMapper.updateById(groupEntity);
    }

    public void delete(Long id) {
        if (Objects.isNull(id)) {
            throw new VerifyBizException("缺少参数");
        }
        groupMapper.deleteById(id);
    }

    public IPage<GroupVO> list(GroupSearchDTO groupDTO) {
        LambdaQueryWrapper<UserGroupEntity> lambda = new LambdaQueryWrapper<>();
        lambda.like(Objects.nonNull(groupDTO.getName()), UserGroupEntity::getName, groupDTO.getName());

        Page<UserGroupEntity> page = new Page<>(Paging.normalizeSize(groupDTO.getPage()), Paging.normalizeSize(groupDTO.getSize()));

        IPage<UserGroupEntity> result = groupMapper.selectPage(page, lambda);

        return GroupConverter.INSTANCE.toPage(result);
    }


    public GroupVO getById(Long groupId) {
        UserGroupEntity group = groupMapper.selectById(groupId);
        if (Objects.isNull(group)) {
            return null;
        }
        return GroupConverter.INSTANCE.toVO(group);
    }
}

