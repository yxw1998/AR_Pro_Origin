package cn.ar.mapper;

import cn.ar.entity.ManagerLoginLog;

public interface ManagerLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManagerLoginLog record);

    int insertSelective(ManagerLoginLog record);

    ManagerLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManagerLoginLog record);

    int updateByPrimaryKey(ManagerLoginLog record);
}