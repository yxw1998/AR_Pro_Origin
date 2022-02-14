package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.entity.TestPo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/11/18 0018 10:21
 * @description
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @ApiOperation("测试接口")
    @PostMapping(value = "/success",produces = "application/json;charset=utf-8")
    public GeneralResult success(@RequestBody TestPo testPo){
        log.info("TestPo--->" + testPo);
        testPo.setName(testPo.getName() + "这是一个测试接口， 罗英测试！");
        return GeneralResult.success(testPo);
    }
}
