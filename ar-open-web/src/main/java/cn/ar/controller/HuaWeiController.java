package cn.ar.controller;

import cn.ar.common.GeneralResult;
import cn.ar.dto.ImageBlock;
import cn.ar.dto.ImageDto;
import cn.ar.dto.ImageDtoH;
import cn.ar.dto.ImgResult;
import cn.ar.util.huawei.HuaWeiUtil;
import cn.ar.util.id.IDUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/15 15:20
 */
@RestController
@RequestMapping("/huawei")
@Slf4j
public class HuaWeiController {

    @PostMapping(value = "/imageSearch", produces = "application/json;charset=utf-8")
    public Object imageSearch(@RequestBody ImageDto imageDto) {
        ImageDtoH imageDtoH = new ImageDtoH();
        if (!StringUtils.isEmpty(imageDto.getQueryContent())) {
            imageDtoH.setLimit(1);
            imageDtoH.setOffset(0);
            imageDtoH.setFile(imageDto.getQueryContent());
        }
        log.info("华为通用图片搜索-----> ");

        String data = HuaWeiUtil.imageSearch(imageDtoH);
        JSONObject jsonObject = JSONObject.parseObject(data);
        JSONArray result = jsonObject.getJSONArray("result");
        String obj = String.valueOf(result.get(0));
        JSONObject j2 = JSONObject.parseObject(obj);

        String cont_sign = String.valueOf(j2.get("path"));
        String score = String.valueOf(j2.get("sim"));

        ImageBlock imageBlock = new ImageBlock();
        ImgResult imgResult = new ImgResult();
        List<ImageBlock> list = new ArrayList<>();

        imageBlock.setScore(score);
        imageBlock.setCont_sign(cont_sign);
        list.add(imageBlock);
        imgResult.setResult(list);
        return imgResult;
    }

    @PostMapping(value = "/imageAdd", produces = "application/json;charset=utf-8")
    public GeneralResult imageAdd(@RequestBody ImageDto imageDto) {
        ImageDtoH imageDtoH = new ImageDtoH();
        String contSign = IDUtils.snowFlakesID();
        if (!StringUtils.isEmpty(imageDto.getQueryContent())) {
            imageDtoH.setFile(imageDto.getQueryContent());
            imageDtoH.setPath(contSign);
        }
        log.info("华为通用图片添加-----> ");
        String data = HuaWeiUtil.imageAdd(imageDtoH);
        if (data != null && data.contains("error_code")) {
            return GeneralResult.fail(data);
        }
        ImgResult imgResult = new ImgResult();
        imgResult.setCont_sign(contSign);
        return GeneralResult.success(imgResult);
    }
}
