package cn.ar.service.impl;

import cn.ar.common.GeneralResult;
import cn.ar.entity.UserInfo;
import cn.ar.entity.UserProHistory;
import cn.ar.mapper.UserMapper;
import cn.ar.mapper.UserProHistoryMapper;
import cn.ar.mapper.UserScanLogMapper;
import cn.ar.service.UserService;
import cn.ar.util.MD5;
import cn.ar.util.NewSnowUtil;
import cn.ar.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangXw
 * @date 2021/11/22 0022 11:32
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private RedisUtil redisUtil;
    private UserProHistoryMapper userProHistoryMapper;

    private UserScanLogMapper userScanLogMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserScanLogMapper(UserScanLogMapper userScanLogMapper) {
        this.userScanLogMapper = userScanLogMapper;
    }

    @Autowired
    public void setUserProHistoryMapper(UserProHistoryMapper userProHistoryMapper) {
        this.userProHistoryMapper = userProHistoryMapper;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public GeneralResult insert(UserInfo userInfo, String userSessCode, String comSessCode) {
        if (userMapper.selectByUserAccount(userInfo) != null) {
            return GeneralResult.fail("账号已存在,请重新输入!");
        }
        try {
            userInfo.setCreaterCode(userSessCode);
            userInfo.setUserCode(String.valueOf(NewSnowUtil.getId()));
            userInfo.setPassword(MD5.getSmallSign(userInfo.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GeneralResult.success(userMapper.insert(userInfo));
    }


    @Override
    public GeneralResult login(UserInfo userInfo, String userSessCode, String comSessCode) {
        try {
            UserInfo loginUser = userMapper.selectByUserAccount(userInfo);
            if (loginUser == null) {
                return GeneralResult.fail("用户名不存在，请重新输入！");
            }
            if (!loginUser.getPassword().equals(MD5.getSmallSign(userInfo.getPassword()))) {
                return GeneralResult.fail("用户名密码不正确，请重新输入！");
            }
            String token = MD5.getSmallSign(loginUser.getUserCode() + loginUser.getPassword() + System.currentTimeMillis());
            loginUser.setToken(token);
            loginUser.setPassword(null);
            redisUtil.set("" + loginUser.getUserCode() + "loginToken", token, 600);
            return GeneralResult.success(loginUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneralResult selByUserCode(UserInfo userInfo, String userSessCode, String comSessCode) {
        return GeneralResult.success(userMapper.selByUserCode(userInfo));
    }

    @Override
    public GeneralResult selAllUser(UserInfo userInfo, String userSessCode, String comSessCode) {
        if (userInfo.getPagination() == 1) {
            PageHelper.startPage(userInfo.getPage(), userInfo.getPageNum());
        }
        return GeneralResult.success(new PageInfo<>(userMapper.selAllUser(userInfo.getUserCodeList())));
    }

    @Override
    public GeneralResult selUserByMiniOpenId(UserInfo userInfo, String userSessCode, String comSessCode) {
        return GeneralResult.success(userMapper.selUserByMiniOpenId(userInfo));
    }

    @Override
    public GeneralResult appletsRegister(UserInfo userInfo, String userSessCode, String comSessCode) {
        if (userMapper.checkRepeat(userInfo) != null){
            return GeneralResult.fail("该OPENID已经注册");
        }
        userInfo.setUserCode(String.valueOf(NewSnowUtil.getId()));
        return GeneralResult.success(userMapper.appletsRegister(userInfo));
    }

    @Override
    public GeneralResult insertUserProHistoryMini(UserProHistory userProHistory, String userSessCode, String comSessCode) {
        UserProHistory checkRepeat = userProHistoryMapper.checkRepeat(userProHistory);
        if (checkRepeat != null) {
            return GeneralResult.success(userProHistoryMapper.updateHistory(userProHistory));
        }
        return GeneralResult.success(userProHistoryMapper.insert(userProHistory));
    }

    @Override
    public GeneralResult selHistoryByMini(UserProHistory userProHistory, String userSessCode, String comSessCode) {
        List<UserProHistory> resultList = userProHistoryMapper.selHistoryByMini(userProHistory);
        if (resultList == null){
            return GeneralResult.fail("用户没有浏览记录！");
        }
        return GeneralResult.success(resultList);
    }

    @Override
    public GeneralResult selUserScanLog(UserInfo userInfo, String userSessCode, String comSessCode) {

        return GeneralResult.success(userScanLogMapper.selUserScanLog(userInfo));
    }
}
