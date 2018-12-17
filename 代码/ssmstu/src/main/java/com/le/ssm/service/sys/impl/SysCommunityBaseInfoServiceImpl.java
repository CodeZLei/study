package com.le.ssm.service.sys.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.le.ssm.dao.sys.SysCommunityBaseInfoMapper;
import com.le.ssm.domain.sys.SysCommunityBaseInfo;
import com.le.ssm.domain.sys.query.SysCommunityBaseInfoQuery;
import com.le.ssm.service.sys.SysCommunityBaseInfoService;

/**
 * <pre>
 * <b>类描述:</b>SysCommunityBaseInfo表对应的业务处理类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
@Service
public class SysCommunityBaseInfoServiceImpl implements SysCommunityBaseInfoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(SysCommunityBaseInfoService.class);
	
	@Resource(name = "sysCommunityBaseInfoMapper")
	private SysCommunityBaseInfoMapper sysCommunityBaseInfoMapper;
	
	@Override
    public int insert(SysCommunityBaseInfo entity){
    	return sysCommunityBaseInfoMapper.insert(entity);
    }

	@Override
    public int deleteByPrimaryKey(String id){
    	return sysCommunityBaseInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysCommunityBaseInfo entity){
    	return sysCommunityBaseInfoMapper.updateByPrimaryKeySelective(entity);
    }
    
    @Override
    public int save(SysCommunityBaseInfo entity) {
        if (null == entity.getId()) {
            entity.setCreateTime(new Date());
            entity.setLastUpdateTime(new Date());
            return this.insert(entity);
        } else {
            entity.setLastUpdateTime(new Date());
            return this.updateByPrimaryKeySelective(entity);
        }
    }

    @Override
    public SysCommunityBaseInfo selectByPrimaryKey(String id){
		return sysCommunityBaseInfoMapper.selectByPrimaryKey(id);    	
    }
    

    @Override
    public List<SysCommunityBaseInfo> selectByEntityQuery(SysCommunityBaseInfoQuery entityQuery){
		return sysCommunityBaseInfoMapper.selectByEntityQuery(entityQuery);
    }
    
}
