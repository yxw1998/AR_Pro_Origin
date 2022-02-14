package cn.ar.mapper;

import cn.ar.entity.UnCustomerUserPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface UnCustomerUserPermissionMapper {


    /**
     * 添加主体账户权限
     * @param unCustomerPermissionList 主体账号权限列表
     * @return
     */
    int insert(@Param("unCustomerPermissionList") List<UnCustomerUserPermission> unCustomerPermissionList);

    /**
     * 查询主体用户权限
     * @param data
     * @return
     */
    UnCustomerUserPermission selCustomerPermission(UnCustomerUserPermission data);

    /**
     * 查询主体子用户权限
     * @param data
     * @return
     */
    UnCustomerUserPermission selCustomerUserPermission(UnCustomerUserPermission data);

    /**
     * 添加主体子账户权限
     * @param unCustomerUserPermissionList
     * @return
     */
    int insertCustomerUser(@Param("unCustomerUserPermissionList")List<UnCustomerUserPermission> unCustomerUserPermissionList);
}