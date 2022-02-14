package cn.ar.mapper;

import cn.ar.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 添加用户信息
     * @param record
     * @return
     */
    int insert(UserInfo record);

    /**
     * 通过账号查询用户
     * @param userInfo
     * @return
     */
    UserInfo selectByUserAccount(UserInfo userInfo);

    /**
     * 通过编号查询用户
     * @param userInfo
     * @return
     */
    UserInfo selByUserCode(UserInfo userInfo);

    /**
     * 查询用户详情列表
     * @param userCodeList
     * @return
     */
    List<UserInfo> selAllUser(@Param("userCodeList") List<String> userCodeList);

    /**
     * 通过miniOpenId查询用户信息
     * @param userInfo
     * @return
     */
    UserInfo selUserByMiniOpenId(UserInfo userInfo);

    /**
     * 小程序注册
     * @param userInfo
     * @return
     */
    int appletsRegister(UserInfo userInfo);

    /**
     * 校验重复
     * @param userInfo
     * @return
     */
    UserInfo checkRepeat(UserInfo userInfo);
}