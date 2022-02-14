package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.dto.ObsDto;
import cn.ar.obs.ObsInstance;
import com.obs.services.model.PostSignatureResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author YangXw
 * @date 2021/11/30 0030 11:09
 * @description
 */
@RestController
@RequestMapping("/obs")
public class ObsController {

    /**
     * 获取Obs SignedUrl ActualSignedRequestHeaders
     * @return
     */
    @PostMapping("/getObsUrl")
    public GeneralResult getObsUrl(@RequestBody @Validated ObsDto obsDto){
        return GeneralResult.success(ObsInstance.createTemporarySignature(obsDto.getObjectName()));
    }

    @PostMapping("/getPostSignature")
    public GeneralResult getPostSignature(){
        PostSignatureResponse result = ObsInstance.createPostSignature();
        ObsDto obsDto = new ObsDto();
        obsDto.setSignature(result.getSignature());
        obsDto.setPolicy(result.getPolicy());
        obsDto.setExpiration(result.getExpiration());
        obsDto.setToken(result.getToken());
        return GeneralResult.success(obsDto);
    }


}
