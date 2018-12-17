package com.le.ssm.domain.da.query;

import java.util.Date;

import com.le.ssm.domain.da.DaAroundCommunityPriceInfo;

/**
 * <pre>
 * <b>类描述:</b>DaAroundCommunityPriceInfo表的对应的查询对象
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public class DaAroundCommunityPriceInfoQuery extends DaAroundCommunityPriceInfo {

    private static final long serialVersionUID = 1L;

    /* 区间查询条件:位置-开始 */
    private Double distanceStart;

    /* 区间查询条件:位置-结束 */
    private Double distanceEnd;

    /* 区间查询条件:x坐标-开始 */
    private Double xlongitudeStart;

    /* 区间查询条件:x坐标-结束 */
    private Double xlongitudeEnd;

    /* 区间查询条件:y坐标-开始 */
    private Double ylatitudeStart;

    /* 区间查询条件:y坐标-结束 */
    private Double ylatitudeEnd;

    /* 区间查询条件:均价-开始 */
    private Double unitPriceStart;

    /* 区间查询条件:均价-结束 */
    private Double unitPriceEnd;

    /* 区间查询条件:创建时间-开始 */
    private Date createTimeStart;

    /* 区间查询条件:创建时间-结束 */
    private Date createTimeEnd;

    /* 区间查询条件:最后修改时间-开始 */
    private Date lastUpdateTimeStart;

    /* 区间查询条件:最后修改时间-结束 */
    private Date lastUpdateTimeEnd;

    /* 排序条件:使用的列名  */
    private String sortColumns;
    
    public Double getDistanceStart(){
        return distanceStart;
    }

    public void setDistanceStart(Double distanceStart){
        this.distanceStart = distanceStart;
    }

    public Double getDistanceEnd(){
        return distanceEnd;
    }

    public void setDistanceEnd(Double distanceEnd){
        this.distanceEnd = distanceEnd;
    }
    public Double getXlongitudeStart(){
        return xlongitudeStart;
    }

    public void setXlongitudeStart(Double xlongitudeStart){
        this.xlongitudeStart = xlongitudeStart;
    }

    public Double getXlongitudeEnd(){
        return xlongitudeEnd;
    }

    public void setXlongitudeEnd(Double xlongitudeEnd){
        this.xlongitudeEnd = xlongitudeEnd;
    }
    public Double getYlatitudeStart(){
        return ylatitudeStart;
    }

    public void setYlatitudeStart(Double ylatitudeStart){
        this.ylatitudeStart = ylatitudeStart;
    }

    public Double getYlatitudeEnd(){
        return ylatitudeEnd;
    }

    public void setYlatitudeEnd(Double ylatitudeEnd){
        this.ylatitudeEnd = ylatitudeEnd;
    }
    public Double getUnitPriceStart(){
        return unitPriceStart;
    }

    public void setUnitPriceStart(Double unitPriceStart){
        this.unitPriceStart = unitPriceStart;
    }

    public Double getUnitPriceEnd(){
        return unitPriceEnd;
    }

    public void setUnitPriceEnd(Double unitPriceEnd){
        this.unitPriceEnd = unitPriceEnd;
    }
    public Date getCreateTimeStart(){
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart){
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd(){
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd){
        this.createTimeEnd = createTimeEnd;
    }
    public Date getLastUpdateTimeStart(){
        return lastUpdateTimeStart;
    }

    public void setLastUpdateTimeStart(Date lastUpdateTimeStart){
        this.lastUpdateTimeStart = lastUpdateTimeStart;
    }

    public Date getLastUpdateTimeEnd(){
        return lastUpdateTimeEnd;
    }

    public void setLastUpdateTimeEnd(Date lastUpdateTimeEnd){
        this.lastUpdateTimeEnd = lastUpdateTimeEnd;
    }
  	public String getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}

	@Override
    public String toString() {
    	String lineSeparator = System.getProperty("line.separator");
    	String separator = "," + lineSeparator;
        StringBuffer str = new StringBuffer();
        str.append(getClass().getName()).append("@").append(hashCode()).append("{").append(lineSeparator);
		str.append("    id=").append(getId()).append(separator);
		str.append("    baseId=").append(getBaseId()).append(separator);
		str.append("    comName=").append(getComName()).append(separator);
		str.append("    csCityCode=").append(getCsCityCode()).append(separator);
		str.append("    cityName=").append(getCityName()).append(separator);
		str.append("    aroundComName=").append(getAroundComName()).append(separator);
		str.append("    distanceStart=").append(getDistanceStart()).append(separator);
		str.append("    distance=").append(getDistance()).append(separator);
		str.append("    distanceEnd=").append(getDistanceEnd()).append(separator);
		str.append("    xlongitudeStart=").append(getXlongitudeStart()).append(separator);
		str.append("    xlongitude=").append(getXlongitude()).append(separator);
		str.append("    xlongitudeEnd=").append(getXlongitudeEnd()).append(separator);
		str.append("    ylatitudeStart=").append(getYlatitudeStart()).append(separator);
		str.append("    ylatitude=").append(getYlatitude()).append(separator);
		str.append("    ylatitudeEnd=").append(getYlatitudeEnd()).append(separator);
		str.append("    unitPriceStart=").append(getUnitPriceStart()).append(separator);
		str.append("    unitPrice=").append(getUnitPrice()).append(separator);
		str.append("    unitPriceEnd=").append(getUnitPriceEnd()).append(separator);
		str.append("    sourceChannel=").append(getSourceChannel()).append(separator);
		str.append("    status=").append(getStatus()).append(separator);
		str.append("    createTimeStart=").append(getCreateTimeStart()).append(separator);
		str.append("    createTime=").append(getCreateTime()).append(separator);
		str.append("    createTimeEnd=").append(getCreateTimeEnd()).append(separator);
		str.append("    lastUpdateTimeStart=").append(getLastUpdateTimeStart()).append(separator);
		str.append("    lastUpdateTime=").append(getLastUpdateTime()).append(separator);
		str.append("    lastUpdateTimeEnd=").append(getLastUpdateTimeEnd()).append(separator);
		str.append("    sortColumns=").append(getSortColumns()).append(lineSeparator);
        str.append("}").append(lineSeparator);
        return str.toString();
    }
}
