package cn.ar.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * user_scan_log
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","updateTime","enable","activity","createrCode"})
public class UserScanLog implements Serializable {
    private Long id;

    /**
     * 用户编号（雪花、唯一）
     */
    private String userCode;

    /**
     * 所属主体编号
     */
    private String customerCode;

    /**
     * 所属项目编号
     */
    private String projectCode;

    /**
     * 基准图编号
     */
    private String mediaCode;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否启用 true 启用 false 不启用
     */
    private Boolean enable;

    /**
     * 是否删除 true 未删除 false 已删除
     */
    private Boolean activity;

    /**
     * 创建人编号
     */
    private String createrCode;

    private static final long serialVersionUID = 1L;
}