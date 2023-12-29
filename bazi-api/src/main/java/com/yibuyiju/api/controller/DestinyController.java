package com.yibuyiju.api.controller;

import com.yibuyiju.api.dto.PredictInfoDTO;
import com.yibuyiju.api.dto.TesterInfoDTO;
import com.yibuyiju.api.service.DestinyService;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/12/26 15:46
 */
@Getter
@RestController
public class DestinyController {

    @Autowired
    DestinyService destinyService;

    @ApiOperation(value = "预测", httpMethod = "POST")
    @PostMapping("/destiny/predict")
    public PredictInfoDTO predict(@RequestBody TesterInfoDTO testerInfoDTO) {


        PredictInfoDTO predictInfoDTO = destinyService.baziInfo(testerInfoDTO);

        return predictInfoDTO;
    }
}
