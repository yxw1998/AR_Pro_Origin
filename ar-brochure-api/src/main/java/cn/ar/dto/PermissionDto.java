package cn.ar.dto;

import cn.ar.entity.UnCustomerUserPermission;
import cn.ar.entity.UnManagerPermission;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/25 0025 13:49
 * @description
 */
@Data
public class PermissionDto {

    private List<UnManagerPermission> unManagerPermissionList;

    /**
     * 主体账户列表
     */
    @Valid
    private List<UnCustomerUserPermission> unCustomerPermissionList;
    /**
     * 主体子账户权限列表
     */
    @Valid
    private List<UnCustomerUserPermission> unCustomerUserPermissionList;

    /**
     * 查询基础权限类型 0 管理员 1 主体
     */
    private Integer type;


}
