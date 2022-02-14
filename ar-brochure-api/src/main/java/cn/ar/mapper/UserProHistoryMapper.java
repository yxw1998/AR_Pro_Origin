package cn.ar.mapper;

import cn.ar.entity.UserProHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Repository
@Mapper
public interface UserProHistoryMapper {

    /**
     * 添加用户浏览项目历史记录信息
     * @param record
     * @return
     */
    int insert(UserProHistory record);

    /**
     * 通过miniOpenId查询用户浏览项目历史记录
     * @param userProHistory
     * @return
     */
    List<UserProHistory> selHistoryByMini(UserProHistory userProHistory);

    /**
     * 校验重复MINI
     * @param userProHistory
     * @return
     */
    UserProHistory checkRepeat(UserProHistory userProHistory);

    /**
     * 更新访问时间
     * @param userProHistory
     * @return
     */
    int updateHistory(UserProHistory userProHistory);
}