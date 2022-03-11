package cn.ar.mapper;

import cn.ar.entity.Customer;
import cn.ar.entity.CustomerTopup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface CustomerTopupMapper {

    /**
     * 主体账号充值次数
     * @param record
     * @return
     */
    int insert(CustomerTopup record);

    /**
     * 查询主体账号充值次数记录
     * @param customer
     * @return
     */
    List<CustomerTopup> selCustomerTopup(Customer customer);
}