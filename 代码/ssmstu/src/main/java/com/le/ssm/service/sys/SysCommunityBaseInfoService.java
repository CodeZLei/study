package com.le.ssm.service.sys;

import java.util.List;

import com.le.ssm.domain.sys.SysCommunityBaseInfo;
import com.le.ssm.domain.sys.query.SysCommunityBaseInfoQuery;

/**
 * <pre>
 * <b>类描述:</b>SysCommunityBaseInfo表对应的业务处理类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public interface SysCommunityBaseInfoService {

	/**
     * 插入数据库记录
     *
     * @param entity
     */
    int insert(SysCommunityBaseInfo entity);

	/**
     * 根据主键删除数据库的记录
     *
	 * @param id
     */
    int deleteByPrimaryKey(String id);
    
    /**
     * 根据主键来更新部分数据库记录
     *
     * @param entity
     */
    int updateByPrimaryKeySelective(SysCommunityBaseInfo entity);
    
    /**
     * 保存数据信息(更新/插入)
     * 
     * @param entity
     */
    int save(SysCommunityBaseInfo entity);
    
    /**
     * 根据主键获取一条数据库记录
     *
	 * @param id
     */
    SysCommunityBaseInfo selectByPrimaryKey(String id);
  
    /**
     * 根据查询对象查找列表数据
     * 
     * @param entityQuery
     * @return 
     */
    List<SysCommunityBaseInfo> selectByEntityQuery(SysCommunityBaseInfoQuery entityQuery);

}