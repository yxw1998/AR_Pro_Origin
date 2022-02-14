package cn.ar.mapper;

import cn.ar.common.GeneralResult;
import cn.ar.entity.Customer;
import cn.ar.entity.CustomerLoginLog;
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
public interface CustomerMapper {

    /**
     * 主体添加
     * @param customer
     * @return
     */
    int insert(Customer customer);

    /**
     * 通过账号查询主体信息
     * @param customer
     * @return
     */
    Customer selectByCustomerAccount(Customer customer);

    /**
     * 通过编号查询主体账号信息详情
     * @param customer
     * @return
     */
    Customer selCustomerByCode(Customer customer);


    /**
     * 查询主体用户信息列表
     * @param customerCodeList
     * @return
     */
    List<Customer> selCustomerList(List<String> customerCodeList);


    /**
     * 查询主体用户登录详情列表
     * @param customerCode 主体账号编号
     * @param customerUserCodeList 主体人员账号编号列表 可选 默认全查
     * @return
     */
    List<CustomerLoginLog> selLoginLog(@Param("customerCode") String customerCode,@Param("customerUserCodeList") List<String> customerUserCodeList);

    /**
     * 添加主体账号登录日志
     * @param customer
     * @return
     */
    int insertLogin(Customer customer);

    /**
     *
     * @param customerCode
     * @param token
     * @return
     */
    int logout(String customerCode, String token);

    /**
     * 查询主体账号登录记录列表
     * @param customerCodeList
     * @return
     */
    List<CustomerLoginLog> selCustomerLoginLog(@Param("customerCodeList") List<String> customerCodeList);

    /**
     * 查询主体子账户权限
     * @param unCustomerUserPermission
     * @return
     */
    List<UnCustomerUserPermission> selCustomerUserPermissionList(UnCustomerUserPermission unCustomerUserPermission);

}