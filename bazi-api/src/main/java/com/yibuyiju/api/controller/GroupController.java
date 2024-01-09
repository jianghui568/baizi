package com.yibuyiju.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yibuyiju.api.config.auth.Logining;
import com.yibuyiju.api.dto.GroupDTO;
import com.yibuyiju.api.dto.GroupSearchDTO;
import com.yibuyiju.api.service.GroupService;
import com.yibuyiju.api.vo.GroupVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/26 15:46
 */
@Api(value = "分组")
@RestController
public class GroupController {
    @Autowired
    GroupService groupService;

    @ApiOperation(value = "分组添加", httpMethod = "POST")
    @Logining
    @PostMapping("/group")
    public GroupVO add(@Valid @RequestBody GroupDTO groupDTO) {
        long groupId = groupService.add(groupDTO);
        return groupService.getById(groupId);
    }

    @Logining
    @ApiOperation(value = "分组修改", httpMethod = "PUT")
    @PutMapping("/group")
    public void update(@RequestBody GroupDTO groupDTO) {
        groupService.update(groupDTO);
    }

    @Logining
    @ApiOperation(value = "分组删除", httpMethod = "DELETE")
    @DeleteMapping("/group/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }

    @Logining
    @ApiOperation(value = "分组列表", httpMethod = "GET")
    @GetMapping("/group")
    public IPage<GroupVO> list(@RequestParam GroupSearchDTO groupDTO) {
        return groupService.list(groupDTO);
    }
}
