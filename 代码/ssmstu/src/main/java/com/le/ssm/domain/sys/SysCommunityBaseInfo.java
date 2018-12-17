package com.le.ssm.domain.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * <b>类描述:</b>SysCommunityBaseInfo表的对应的java对象，该文件为工具自动生成
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public class SysCommunityBaseInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 
     * 主键 
     * 数据库字段: id
     */
    private String id;
    /** 
     * 楼盘名称 
     * 数据库字段: com_name
     */
    private String comName;
    /** 
     * 城市编号 
     * 数据库字段: cs_city_code
     */
    private String csCityCode;
    /** 
     * 城市名称 
     * 数据库字段: city_name
     */
    private String cityName;
    /** 
     * 区域编号 
     * 数据库字段: district_code
     */
    private String districtCode;
    /** 
     * 区域名称 
     * 数据库字段: district_name
     */
    private String districtName;
    /** 
     * 地址 
     * 数据库字段: address
     */
    private String address;
    /** 
     * 均价 
     * 数据库字段: unit_price
     */
    private Double unitPrice;
    /** 
     * 上月价格浮动比例 
     * 数据库字段: ratio_by_last_month_for_price
     */
    private Double ratioByLastMonthForPrice;
    /** 
     * 上年价格浮动比例 
     * 数据库字段: ratio_by_last_year_for_price
     */
    private Double ratioByLastYearForPrice;
    /** 
     * x坐标 
     * 数据库字段: xlongitude
     */
    private Double xlongitude;
    /** 
     * y坐标 
     * 数据库字段: ylongitude
     */
    private Double ylongitude;
    /** 
     * 房子类型 
     * 数据库字段: house_types
     */
    private String houseTypes;
    /** 
     * 学校 
     * 数据库字段: school_district_housing
     */
    private String schoolDistrictHousing;
    /** 
     * 地铁 
     * 数据库字段: subway_district_housing
     */
    private String subwayDistrictHousing;
    /** 
     * 完成shiji8an 
     * 数据库字段: completion_date
     */
    private String completionDate;
    /** 
     * 类型 
     * 数据库字段: building_category
     */
    private String buildingCategory;
    /** 
     * 开发公司 
     * 数据库字段: developer_company
     */
    private String developerCompany;
    /** 
     * 售卖时间 
     * 数据库字段: sell_date
     */
    private String sellDate;
    /** 
     * 时间 
     * 数据库字段: building_area
     */
    private Double buildingArea;
    /** 
     * 绿化 
     * 数据库字段: land_area
     */
    private Double landArea;
    /** 
     * 时间 
     * 数据库字段: land_use_years_limit
     */
    private Integer landUseYearsLimit;
    /** 
     * 比率 
     * 数据库字段: greening_rate
     */
    private Double greeningRate;
    /** 
     * 公司 
     * 数据库字段: management_company
     */
    private String managementCompany;
    /** 
     * 物业 
     * 数据库字段: management_fees
     */
    private Double managementFees;
    /** 
     * 公园 
     * 数据库字段: parking_space_info
     */
    private String parkingSpaceInfo;
    /** 
     * 学校 
     * 数据库字段: school
     */
    private String school;
    /** 
     * 公家 
     * 数据库字段: subway_line
     */
    private String subwayLine;
    /** 
     * 地铁 
     * 数据库字段: bus_line
     */
    private String busLine;
    /** 
     * 数据来源渠道 
     * 数据库字段: source_channel
     */
    private String sourceChannel;
    /** 
     * 状态 
     * 数据库字段: status
     */
    private String status;
    /** 
     * 创建时间 
     * 数据库字段: create_time
     */
    private Date createTime;
    /** 
     * 最后修改时间 
     * 数据库字段: last_update_time
     */
    private Date lastUpdateTime;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getComName(){
        return comName;
    }
    public void setComName(String comName){
        this.comName = comName;
    }

    public String getCsCityCode(){
        return csCityCode;
    }
    public void setCsCityCode(String csCityCode){
        this.csCityCode = csCityCode;
    }

    public String getCityName(){
        return cityName;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getDistrictCode(){
        return districtCode;
    }
    public void setDistrictCode(String districtCode){
        this.districtCode = districtCode;
    }

    public String getDistrictName(){
        return districtName;
    }
    public void setDistrictName(String districtName){
        this.districtName = districtName;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public Double getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice){
        this.unitPrice = unitPrice;
    }

    public Double getRatioByLastMonthForPrice(){
        return ratioByLastMonthForPrice;
    }
    public void setRatioByLastMonthForPrice(Double ratioByLastMonthForPrice){
        this.ratioByLastMonthForPrice = ratioByLastMonthForPrice;
    }

    public Double getRatioByLastYearForPrice(){
        return ratioByLastYearForPrice;
    }
    public void setRatioByLastYearForPrice(Double ratioByLastYearForPrice){
        this.ratioByLastYearForPrice = ratioByLastYearForPrice;
    }

    public Double getXlongitude(){
        return xlongitude;
    }
    public void setXlongitude(Double xlongitude){
        this.xlongitude = xlongitude;
    }

    public Double getYlongitude(){
        return ylongitude;
    }
    public void setYlongitude(Double ylongitude){
        this.ylongitude = ylongitude;
    }

    public String getHouseTypes(){
        return houseTypes;
    }
    public void setHouseTypes(String houseTypes){
        this.houseTypes = houseTypes;
    }

    public String getSchoolDistrictHousing(){
        return schoolDistrictHousing;
    }
    public void setSchoolDistrictHousing(String schoolDistrictHousing){
        this.schoolDistrictHousing = schoolDistrictHousing;
    }

    public String getSubwayDistrictHousing(){
        return subwayDistrictHousing;
    }
    public void setSubwayDistrictHousing(String subwayDistrictHousing){
        this.subwayDistrictHousing = subwayDistrictHousing;
    }

    public String getCompletionDate(){
        return completionDate;
    }
    public void setCompletionDate(String completionDate){
        this.completionDate = completionDate;
    }

    public String getBuildingCategory(){
        return buildingCategory;
    }
    public void setBuildingCategory(String buildingCategory){
        this.buildingCategory = buildingCategory;
    }

    public String getDeveloperCompany(){
        return developerCompany;
    }
    public void setDeveloperCompany(String developerCompany){
        this.developerCompany = developerCompany;
    }

    public String getSellDate(){
        return sellDate;
    }
    public void setSellDate(String sellDate){
        this.sellDate = sellDate;
    }

    public Double getBuildingArea(){
        return buildingArea;
    }
    public void setBuildingArea(Double buildingArea){
        this.buildingArea = buildingArea;
    }

    public Double getLandArea(){
        return landArea;
    }
    public void setLandArea(Double landArea){
        this.landArea = landArea;
    }

    public Integer getLandUseYearsLimit(){
        return landUseYearsLimit;
    }
    public void setLandUseYearsLimit(Integer landUseYearsLimit){
        this.landUseYearsLimit = landUseYearsLimit;
    }

    public Double getGreeningRate(){
        return greeningRate;
    }
    public void setGreeningRate(Double greeningRate){
        this.greeningRate = greeningRate;
    }

    public String getManagementCompany(){
        return managementCompany;
    }
    public void setManagementCompany(String managementCompany){
        this.managementCompany = managementCompany;
    }

    public Double getManagementFees(){
        return managementFees;
    }
    public void setManagementFees(Double managementFees){
        this.managementFees = managementFees;
    }

    public String getParkingSpaceInfo(){
        return parkingSpaceInfo;
    }
    public void setParkingSpaceInfo(String parkingSpaceInfo){
        this.parkingSpaceInfo = parkingSpaceInfo;
    }

    public String getSchool(){
        return school;
    }
    public void setSchool(String school){
        this.school = school;
    }

    public String getSubwayLine(){
        return subwayLine;
    }
    public void setSubwayLine(String subwayLine){
        this.subwayLine = subwayLine;
    }

    public String getBusLine(){
        return busLine;
    }
    public void setBusLine(String busLine){
        this.busLine = busLine;
    }

    public String getSourceChannel(){
        return sourceChannel;
    }
    public void setSourceChannel(String sourceChannel){
        this.sourceChannel = sourceChannel;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getLastUpdateTime(){
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
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
        str.append("    unitPrice=").append(getUnitPrice()).append(separator);
        str.append("    ratioByLastMonthForPrice=").append(getRatioByLastMonthForPrice()).append(separator);
        str.append("    ratioByLastYearForPrice=").append(getRatioByLastYearForPrice()).append(separator);
        str.append("    xlongitude=").append(getXlongitude()).append(separator);
        str.append("    ylongitude=").append(getYlongitude()).append(separator);
        str.append("    houseTypes=").append(getHouseTypes()).append(separator);
        str.append("    schoolDistrictHousing=").append(getSchoolDistrictHousing()).append(separator);
        str.append("    subwayDistrictHousing=").append(getSubwayDistrictHousing()).append(separator);
        str.append("    completionDate=").append(getCompletionDate()).append(separator);
        str.append("    buildingCategory=").append(getBuildingCategory()).append(separator);
        str.append("    developerCompany=").append(getDeveloperCompany()).append(separator);
        str.append("    sellDate=").append(getSellDate()).append(separator);
        str.append("    buildingArea=").append(getBuildingArea()).append(separator);
        str.append("    landArea=").append(getLandArea()).append(separator);
        str.append("    landUseYearsLimit=").append(getLandUseYearsLimit()).append(separator);
        str.append("    greeningRate=").append(getGreeningRate()).append(separator);
        str.append("    managementCompany=").append(getManagementCompany()).append(separator);
        str.append("    managementFees=").append(getManagementFees()).append(separator);
        str.append("    parkingSpaceInfo=").append(getParkingSpaceInfo()).append(separator);
        str.append("    school=").append(getSchool()).append(separator);
        str.append("    subwayLine=").append(getSubwayLine()).append(separator);
        str.append("    busLine=").append(getBusLine()).append(separator);
        str.append("    sourceChannel=").append(getSourceChannel()).append(separator);
        str.append("    status=").append(getStatus()).append(separator);
        str.append("    createTime=").append(getCreateTime()).append(separator);
        str.append("    lastUpdateTime=").append(getLastUpdateTime()).append(lineSeparator);
        str.append("}").append(lineSeparator);
        return str.toString();
    }
}
