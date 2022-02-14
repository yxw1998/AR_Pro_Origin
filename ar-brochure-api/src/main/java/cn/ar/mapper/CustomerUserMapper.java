package cn.ar.mapper;

import cn.ar.entity.CustomerUser;
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
public interface CustomerUserMapper {


    /**
     * 创建主体用户信息
     * @param customerUser
     * @return
     */
    int insert(CustomerUser customerUser);

    /**
     * 通过编号查询主体用户信息详情
     * @param customerUser
     * @return
     */
    CustomerUser selCustomerUserByCode(CustomerUser customerUser);

    /**
     * 通过账号查询主体用户信息详情
     * @param customerUser
     * @return
     */
    CustomerUser selCustomerUserByAccount(CustomerUser customerUser);

    /**
     * 查询主体用户信息详情列表
     * @param customerUserCodeList
     * @param customerCode
     * @return
     */
    List<CustomerUser> selCustomerUserList(@Param("customerUserCodeList") List<String> customerUserCodeList,
                                           @Param("customerCode") String customerCode);

    /**
     * 添加登录记录日志
     * @param customerUser
     * @return
     */
    int insertLogin(CustomerUser customerUser);

    /**
     * 主体用户账号登出
     * @param code
     * @param token
     * @return
     */
    int logout(String code, String token);
}