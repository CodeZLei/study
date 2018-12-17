package com.le.ssm.service.da.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.le.ssm.dao.da.DaAroundCommunityPriceInfoMapper;
import com.le.ssm.domain.da.DaAroundCommunityPriceInfo;
import com.le.ssm.domain.da.query.DaAroundCommunityPriceInfoQuery;
import com.le.ssm.service.da.DaAroundCommunityPriceInfoService;

/**
 * <pre>
 * <b>类描述:</b>DaAroundCommunityPriceInfo表对应的业务处理类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
@Service
public class DaAroundCommunityPriceInfoServiceImpl implements DaAroundCommunityPriceInfoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(DaAroundCommunityPriceInfoService.class);
	
	@Resource(name = "daAroundCommunityPriceInfoMapper")
	private DaAroundCommunityPriceInfoMapper daAroundCommunityPriceInfoMapper;
	
	@Override
    public int insert(DaAroundCommunityPriceInfo entity){
    	return daAroundCommunityPriceInfoMapper.insert(entity);
    }

	@Override
    public int deleteByPrimaryKey(String id){
    	return daAroundCommunityPriceInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DaAroundCommunityPriceInfo entity){
    	return daAroundCommunityPriceInfoMapper.updateByPrimaryKeySelective(entity);
    }
    
    @Override
    public int save(DaAroundCommunityPriceInfo entity) {
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
    public DaAroundCommunityPriceInfo selectByPrimaryKey(String id){
		return daAroundCommunityPriceInfoMapper.selectByPrimaryKey(id);    	
    }
    

    @Override
    public List<DaAroundCommunityPriceInfo> selectByEntityQuery(DaAroundCommunityPriceInfoQuery entityQuery){
		return daAroundCommunityPriceInfoMapper.selectByEntityQuery(entityQuery);
    }
    
}
