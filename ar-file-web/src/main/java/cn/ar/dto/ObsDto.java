package cn.ar.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author YangXw
 * @date 2021/11/30 0030 13:20
 * @description
 */
@Data
public class ObsDto {
    private String requestUrl = "xx.myhuaweicloud.com";
    private String accessKeyId = "ak";
    private String policy;
    private String signature;
    private String expiration;
    private String token;

    @NotBlank(message = "ObjectName 不能为null值或者空字符串!")
    private String ObjectName;
}
