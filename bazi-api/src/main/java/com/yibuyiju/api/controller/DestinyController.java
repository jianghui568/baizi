package com.yibuyiju.api.controller;

import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.service.DestinyService;
import com.yibuyiju.api.vo.PredictInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/26 15:46
 */
@Api(value = "预测")
@RestController
public class DestinyController {

    @Autowired
    DestinyService destinyService;

    @ApiOperation(value = "预测", httpMethod = "POST")
    @PostMapping("/destiny/predict")
    public PredictInfoVO predict(@Valid @RequestBody TesterDTO tester) {


        PredictInfoVO predictInfo = destinyService.baziInfo(tester);

        return predictInfo;
    }
}
