package cn.ar.controller;


import cn.ar.common.GeneralResult;
import cn.ar.dto.ImageDto;
import cn.ar.util.baidu.SimilarAdd;
import cn.ar.util.baidu.SimilarDelete;
import cn.ar.util.baidu.SimilarSearch;
import cn.ar.util.baidu.SimilarUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YangXw
 * @date 2021/11/15 0015 17:55
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/bd")
public class BaiduController {

    @PostMapping(value = "/putInStorage", produces = "application/json;charset=UTF-8")
    public GeneralResult putInStorage(@RequestBody ImageDto imageDto) {
        System.out.println("百度图片上传");
        log.info("百度图片上传--->");
        String s = SimilarAdd.similarAdd(imageDto.getQueryContent());
        if (s.contains("error_code")){
            return GeneralResult.fail(s);
        }
        return GeneralResult.success(s);
    }

    @PostMapping(value = "/imageSearch", produces = "application/json;charset=UTF-8")
    public Object imageSearch(@RequestBody ImageDto imageDto) {
        return SimilarSearch.similarSearch(imageDto.getQueryContent());
    }

    @PostMapping(value = "/imageDelete", produces = "application/json;charset=UTF-8")
    public Object imageDelete(@RequestBody ImageDto imageDto) {
        StringBuilder builder = new StringBuilder();
        imageDto.getContSignList().forEach(data -> {
            builder.append(data).append(";");
        });
        if (builder.length() > 0) {
            String contSign = builder.delete(builder.length() - 1, builder.length()).toString();
            return SimilarDelete.similarDelete2(contSign);
        }
        return "{\"data\":\"图片为空\"}";
    }

    @PostMapping(value = "/imageUpdate", produces = "application/json;charset=UTF-8")
    public Object imageUpdate(@RequestBody ImageDto imageDto) {
        log.info("imageUpdate----->" + imageDto);
        return SimilarUpdate.similarUpdate(imageDto);
    }
}
