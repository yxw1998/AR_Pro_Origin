package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.dto.WxVo;
import cn.ar.util.WxUtil.WxUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/04 13:52
 */
@RestController
@RequestMapping("/wx")
public class WxController {

    /**
     * 获取小程序OPENID
     * @param wxVo
     * @return
     */
    @PostMapping(value = "/getOpenId",produces = "application/json;charset=utf-8")
    public GeneralResult<Object> getOpenId(@RequestBody WxVo wxVo){
        return GeneralResult.success(WxUtil.getCode2Session(wxVo.getCode()));
    }
}
