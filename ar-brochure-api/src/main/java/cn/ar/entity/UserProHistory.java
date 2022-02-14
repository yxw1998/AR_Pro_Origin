package cn.ar.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * user_pro_history
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","updateTime","enable","activity","createrCode"})
public class UserProHistory implements Serializable {
    /**
     *  
     */
    private Long id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户编号
     */
    private String miniOpenId;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目简介
     */
    private String projectIntroduce;

    /**
     * 宣传册封面图
     */
    private String bookCover;

    /**
     * 创建时间
     */
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