package cn.ar.service;

import cn.ar.common.GeneralResult;
import cn.ar.entity.UserInfo;
import cn.ar.entity.UserProHistory;

/**
 * @author YangXw
 * @date 2021/11/22 0022 11:32
 * @description
 */
public interface UserService {

    /**
     * 用户注册添加
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insert(UserInfo userInfo,String userSessCode,String comSessCode);

    /**
     * 用户登录
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult login(UserInfo userInfo,String userSessCode,String comSessCode);


    /**
     * 用户登录
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selByUserCode(UserInfo userInfo,String userSessCode,String comSessCode);

    /**
     * 用户详情列表查询
     * @return
     */
    GeneralResult selAllUser(UserInfo userInfo,String userSessCode,String comSessCode);

    /**
     * 通过miniOpenId查询用户信息
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserByMiniOpenId(UserInfo userInfo, String userSessCode, String comSessCode);

    /**
     * 小程序注册
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult appletsRegister(UserInfo userInfo, String userSessCode, String comSessCode);

    /**
     * 新增用户浏览项目记录[小程序端]
     * @param UserProHistory
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult insertUserProHistoryMini(UserProHistory UserProHistory, String userSessCode, String comSessCode);

    /**
     * 通过miniOpenId查询用户浏览项目历史记录[小程序端]
     * @param userProHistory
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selHistoryByMini(UserProHistory userProHistory, String userSessCode, String comSessCode);

    /**
     * 查询用户扫描识别记录
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    GeneralResult selUserScanLog(UserInfo userInfo, String userSessCode, String comSessCode);
}
