package com.le.ssm.domain.sys.query;

import java.util.Date;

import com.le.ssm.domain.sys.SysCommunityBaseInfo;

/**
 * <pre>
 * <b>类描述:</b>SysCommunityBaseInfo表的对应的查询对象
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public class SysCommunityBaseInfoQuery extends SysCommunityBaseInfo {

    private static final long serialVersionUID = 1L;

    /* 区间查询条件:均价-开始 */
    private Double unitPriceStart;

    /* 区间查询条件:均价-结束 */
    private Double unitPriceEnd;

    /* 区间查询条件:上月价格浮动比例-开始 */
    private Double ratioByLastMonthForPriceStart;

    /* 区间查询条件:上月价格浮动比例-结束 */
    private Double ratioByLastMonthForPriceEnd;

    /* 区间查询条件:上年价格浮动比例-开始 */
    private Double ratioByLastYearForPriceStart;

    /* 区间查询条件:上年价格浮动比例-结束 */
    private Double ratioByLastYearForPriceEnd;

    /* 区间查询条件:x坐标-开始 */
    private Double xlongitudeStart;

    /* 区间查询条件:x坐标-结束 */
    private Double xlongitudeEnd;

    /* 区间查询条件:y坐标-开始 */
    private Double ylongitudeStart;

    /* 区间查询条件:y坐标-结束 */
    private Double ylongitudeEnd;

    /* 区间查询条件:时间-开始 */
    private Double buildingAreaStart;

    /* 区间查询条件:时间-结束 */
    private Double buildingAreaEnd;

    /* 区间查询条件:绿化-开始 */
    private Double landAreaStart;

    /* 区间查询条件:绿化-结束 */
    private Double landAreaEnd;

    /* 区间查询条件:时间-开始 */
    private Integer landUseYearsLimitStart;

    /* 区间查询条件:时间-结束 */
    private Integer landUseYearsLimitEnd;

    /* 区间查询条件:比率-开始 */
    private Double greeningRateStart;

    /* 区间查询条件:比率-结束 */
    private Double greeningRateEnd;

    /* 区间查询条件:物业-开始 */
    private Double managementFeesStart;

    /* 区间查询条件:物业-结束 */
    private Double managementFeesEnd;

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
    public Double getRatioByLastMonthForPriceStart(){
        return ratioByLastMonthForPriceStart;
    }

    public void setRatioByLastMonthForPriceStart(Double ratioByLastMonthForPriceStart){
        this.ratioByLastMonthForPriceStart = ratioByLastMonthForPriceStart;
    }

    public Double getRatioByLastMonthForPriceEnd(){
        return ratioByLastMonthForPriceEnd;
    }

    public void setRatioByLastMonthForPriceEnd(Double ratioByLastMonthForPriceEnd){
        this.ratioByLastMonthForPriceEnd = ratioByLastMonthForPriceEnd;
    }
    public Double getRatioByLastYearForPriceStart(){
        return ratioByLastYearForPriceStart;
    }

    public void setRatioByLastYearForPriceStart(Double ratioByLastYearForPriceStart){
        this.ratioByLastYearForPriceStart = ratioByLastYearForPriceStart;
    }

    public Double getRatioByLastYearForPriceEnd(){
        return ratioByLastYearForPriceEnd;
    }

    public void setRatioByLastYearForPriceEnd(Double ratioByLastYearForPriceEnd){
        this.ratioByLastYearForPriceEnd = ratioByLastYearForPriceEnd;
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
    public Double getYlongitudeStart(){
        return ylongitudeStart;
    }

    public void setYlongitudeStart(Double ylongitudeStart){
        this.ylongitudeStart = ylongitudeStart;
    }

    public Double getYlongitudeEnd(){
        return ylongitudeEnd;
    }

    public void setYlongitudeEnd(Double ylongitudeEnd){
        this.ylongitudeEnd = ylongitudeEnd;
    }
    public Double getBuildingAreaStart(){
        return buildingAreaStart;
    }

    public void setBuildingAreaStart(Double buildingAreaStart){
        this.buildingAreaStart = buildingAreaStart;
    }

    public Double getBuildingAreaEnd(){
        return buildingAreaEnd;
    }

    public void setBuildingAreaEnd(Double buildingAreaEnd){
        this.buildingAreaEnd = buildingAreaEnd;
    }
    public Double getLandAreaStart(){
        return landAreaStart;
    }

    public void setLandAreaStart(Double landAreaStart){
        this.landAreaStart = landAreaStart;
    }

    public Double getLandAreaEnd(){
        return landAreaEnd;
    }

    public void setLandAreaEnd(Double landAreaEnd){
        this.landAreaEnd = landAreaEnd;
    }
    public Integer getLandUseYearsLimitStart(){
        return landUseYearsLimitStart;
    }

    public void setLandUseYearsLimitStart(Integer landUseYearsLimitStart){
        this.landUseYearsLimitStart = landUseYearsLimitStart;
    }

    public Integer getLandUseYearsLimitEnd(){
        return landUseYearsLimitEnd;
    }

    public void setLandUseYearsLimitEnd(Integer landUseYearsLimitEnd){
        this.landUseYearsLimitEnd = landUseYearsLimitEnd;
    }
    public Double getGreeningRateStart(){
        return greeningRateStart;
    }

    public void setGreeningRateStart(Double greeningRateStart){
        this.greeningRateStart = greeningRateStart;
    }

    public Double getGreeningRateEnd(){
        return greeningRateEnd;
    }

    public void setGreeningRateEnd(Double greeningRateEnd){
        this.greeningRateEnd = greeningRateEnd;
    }
    public Double getManagementFeesStart(){
        return managementFeesStart;
    }

    public void setManagementFeesStart(Double managementFeesStart){
        this.managementFeesStart = managementFeesStart;
    }

    public Double getManagementFeesEnd(){
        return managementFeesEnd;
    }

    public void setManagementFeesEnd(Double managementFeesEnd){
        this.managementFeesEnd = managementFeesEnd;
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
		str.append("    comName=").append(getComName()).append(separator);
		str.append("    csCityCode=").append(getCsCityCode()).append(separator);
		str.append("    cityName=").append(getCityName()).append(separator);
		str.append("    districtCode=").append(getDistrictCode()).append(separator);
		str.append("    districtName=").append(getDistrictName()).append(separator);
		str.append("    address=").append(getAddress()).append(separator);
		str.append("    unitPriceStart=").append(getUnitPriceStart()).append(separator);
		str.append("    unitPrice=").append(getUnitPrice()).append(separator);
		str.append("    unitPriceEnd=").append(getUnitPriceEnd()).append(separator);
		str.append("    ratioByLastMonthForPriceStart=").append(getRatioByLastMonthForPriceStart()).append(separator);
		str.append("    ratioByLastMonthForPrice=").append(getRatioByLastMonthForPrice()).append(separator);
		str.append("    ratioByLastMonthForPriceEnd=").append(getRatioByLastMonthForPriceEnd()).append(separator);
		str.append("    ratioByLastYearForPriceStart=").append(getRatioByLastYearForPriceStart()).append(separator);
		str.append("    ratioByLastYearForPrice=").append(getRatioByLastYearForPrice()).append(separator);
		str.append("    ratioByLastYearForPriceEnd=").append(getRatioByLastYearForPriceEnd()).append(separator);
		str.append("    xlongitudeStart=").append(getXlongitudeStart()).append(separator);
		str.append("    xlongitude=").append(getXlongitude()).append(separator);
		str.append("    xlongitudeEnd=").append(getXlongitudeEnd()).append(separator);
		str.append("    ylongitudeStart=").append(getYlongitudeStart()).append(separator);
		str.append("    ylongitude=").append(getYlongitude()).append(separator);
		str.append("    ylongitudeEnd=").append(getYlongitudeEnd()).append(separator);
		str.append("    houseTypes=").append(getHouseTypes()).append(separator);
		str.append("    schoolDistrictHousing=").append(getSchoolDistrictHousing()).append(separator);
		str.append("    subwayDistrictHousing=").append(getSubwayDistrictHousing()).append(separator);
		str.append("    completionDate=").append(getCompletionDate()).append(separator);
		str.append("    buildingCategory=").append(getBuildingCategory()).append(separator);
		str.append("    developerCompany=").append(getDeveloperCompany()).append(separator);
		str.append("    sellDate=").append(getSellDate()).append(separator);
		str.append("    buildingAreaStart=").append(getBuildingAreaStart()).append(separator);
		str.append("    buildingArea=").append(getBuildingArea()).append(separator);
		str.append("    buildingAreaEnd=").append(getBuildingAreaEnd()).append(separator);
		str.append("    landAreaStart=").append(getLandAreaStart()).append(separator);
		str.append("    landArea=").append(getLandArea()).append(separator);
		str.append("    landAreaEnd=").append(getLandAreaEnd()).append(separator);
		str.append("    landUseYearsLimitStart=").append(getLandUseYearsLimitStart()).append(separator);
		str.append("    landUseYearsLimit=").append(getLandUseYearsLimit()).append(separator);
		str.append("    landUseYearsLimitEnd=").append(getLandUseYearsLimitEnd()).append(separator);
		str.append("    greeningRateStart=").append(getGreeningRateStart()).append(separator);
		str.append("    greeningRate=").append(getGreeningRate()).append(separator);
		str.append("    greeningRateEnd=").append(getGreeningRateEnd()).append(separator);
		str.append("    managementCompany=").append(getManagementCompany()).append(separator);
		str.append("    managementFeesStart=").append(getManagementFeesStart()).append(separator);
		str.append("    managementFees=").append(getManagementFees()).append(separator);
		str.append("    managementFeesEnd=").append(getManagementFeesEnd()).append(separator);
		str.append("    parkingSpaceInfo=").append(getParkingSpaceInfo()).append(separator);
		str.append("    school=").append(getSchool()).append(separator);
		str.append("    subwayLine=").append(getSubwayLine()).append(separator);
		str.append("    busLine=").append(getBusLine()).append(separator);
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
