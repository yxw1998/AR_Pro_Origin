package cn.ar.mapper;

import cn.ar.entity.Permission;
import cn.ar.entity.UnManagerPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author YangXw
 */
@Mapper
public interface UnManagerPermissionMapper {

    /**
     * 添加管理员权限
     * @param unManagerPermissionList
     * @return
     */
    int insert(@Param("unManagerPermissionList") List<UnManagerPermission> unManagerPermissionList);

    /**
     * 查询指定管理员账户下的所有权限编号
     * @param unManagerPermission
     * @return
     */
    UnManagerPermission selPermission(UnManagerPermission unManagerPermission);

    /**
     * 查询管理员全部基本权限
     * @return
     */
    List<Permission> selManagerBasePermission();

    /**
     * 查询主体全部基本权限
     * @return
     */
    List<Permission> selCustomerBasePermission();
}