package cn.ar.mapper;

import cn.ar.entity.UserInfo;
import cn.ar.entity.UserScanLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface UserScanLogMapper {

    int insert(UserScanLog record);

    /**
     * 查询用户扫描识别记录
     * @param userInfo
     * @return
     */
    List<UserScanLog> selUserScanLog(UserInfo userInfo);
}