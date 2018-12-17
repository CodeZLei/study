package com.le.ssm.dao.da;

import java.util.List;

import com.le.ssm.domain.da.DaAroundCommunityPriceInfo;
import com.le.ssm.domain.da.query.DaAroundCommunityPriceInfoQuery;

/**
 * <pre>
 * <b>类描述:</b>DaAroundCommunityPriceInfo表对应的数据库操作类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public interface DaAroundCommunityPriceInfoMapper{

	/**
     * 插入数据库记录
     *
     * @param entity
     */
    int insert(DaAroundCommunityPriceInfo entity);
    
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
    int updateByPrimaryKeySelective(DaAroundCommunityPriceInfo entity);
    
    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    DaAroundCommunityPriceInfo selectByPrimaryKey(String id);
  
    /**
     * 根据相应的参数查找对象
     * 
     * @param entityQuery
     * @return 
     */
    List<DaAroundCommunityPriceInfo> selectByEntityQuery(DaAroundCommunityPriceInfoQuery entityQuery);

}