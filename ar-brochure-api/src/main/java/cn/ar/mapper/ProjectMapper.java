package cn.ar.mapper;

import cn.ar.entity.ProjectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangXw
 */
@Mapper
@Repository
public interface ProjectMapper {

    /**
     * 添加主体项目详情
     * @param projectInfo
     * @return
     */
    int insert(ProjectInfo projectInfo);

    /**
     * 通过Name查询项目详情
     * @param projectInfo
     * @return
     */
    ProjectInfo selByName(ProjectInfo projectInfo);

    /**
     * 查询主体项目信息详情列表
     * @param projectInfo
     * @return
     */
    List<ProjectInfo> selProjectList(ProjectInfo projectInfo);
}