package cn.ar.mapper;

import cn.ar.entity.Customer;
import cn.ar.entity.CustomerLeft;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface CustomerLeftMapper {

    int insert(CustomerLeft record);

    /**
     * 查询主体账号剩余扫描次数
     * @param customer
     * @return
     */
    CustomerLeft selCustomerLeft(Customer customer);

    /**
     * 更新主题账号剩余扫描次数
     * @param customerCode
     * @param topupCount
     */
    void updateLeft(@Param("customerCode") String customerCode, @Param("topupCount") Integer topupCount);
}