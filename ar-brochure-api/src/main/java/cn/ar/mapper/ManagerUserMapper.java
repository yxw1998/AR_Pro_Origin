package cn.ar.mapper;

import cn.ar.entity.CustomerLoginLog;
import cn.ar.entity.ManagerLoginLog;
import cn.ar.entity.ManagerUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ManagerUserMapper {

    /**
     * 添加管理员账号
     * @param managerUser
     * @return
     */
    int insert(ManagerUser managerUser);


    /**
     * 通过账号查询管理员用户
     * @param managerUser
     * @return
     */
    ManagerUser selByMaUserAccount(ManagerUser managerUser);

    /**
     * 通过编号查询管理员用户
     * @param managerUser
     * @return
     */
    ManagerUser selByMaUserCode(ManagerUser managerUser);


    /**
     * 查询管理员账号详情列表
     * @param managerUserCodeList
     * @return
     */
    List<ManagerUser> selAllMaUser(@Param("managerUserCodeList") List<String> managerUserCodeList);

    /**
     * 添加登录记录日志
     * @param managerUser
     * @return
     */
    int insertLogin(ManagerUser managerUser);

    /**
     * 管理员登出
     * @param code
     * @param token
     * @return
     */
    int logout(@Param("code") String code,@Param("token") String token);


    /**
     * 查看管理员登录记录列表
     * @param managerUserCodeList
     * @return
     */
    List<ManagerLoginLog> selLoginLog(@Param("managerUserCodeList") List<String> managerUserCodeList);


}