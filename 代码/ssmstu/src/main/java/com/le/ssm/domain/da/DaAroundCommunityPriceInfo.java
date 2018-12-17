package com.le.ssm.domain.da;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * <b>类描述:</b>DaAroundCommunityPriceInfo表的对应的java对象，该文件为工具自动生成
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>2018-12-17 06:50:05
 * </pre>
 */
public class DaAroundCommunityPriceInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 
     * 编号 
     * 数据库字段: id
     */
    private String id;
    /** 
     * 小区编号 
     * 数据库字段: base_id
     */
    private String baseId;
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
     * 周边楼盘名称 
     * 数据库字段: around_com_name
     */
    private String aroundComName;
    /** 
     * 位置 
     * 数据库字段: distance
     */
    private Double distance;
    /** 
     * x坐标 
     * 数据库字段: xlongitude
     */
    private Double xlongitude;
    /** 
     * y坐标 
     * 数据库字段: ylatitude
     */
    private Double ylatitude;
    /** 
     * 均价 
     * 数据库字段: unit_price
     */
    private Double unitPrice;
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

    public String getBaseId(){
        return baseId;
    }
    public void setBaseId(String baseId){
        this.baseId = baseId;
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

    public String getAroundComName(){
        return aroundComName;
    }
    public void setAroundComName(String aroundComName){
        this.aroundComName = aroundComName;
    }

    public Double getDistance(){
        return distance;
    }
    public void setDistance(Double distance){
        this.distance = distance;
    }

    public Double getXlongitude(){
        return xlongitude;
    }
    public void setXlongitude(Double xlongitude){
        this.xlongitude = xlongitude;
    }

    public Double getYlatitude(){
        return ylatitude;
    }
    public void setYlatitude(Double ylatitude){
        this.ylatitude = ylatitude;
    }

    public Double getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice){
        this.unitPrice = unitPrice;
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
        str.append("    baseId=").append(getBaseId()).append(separator);
        str.append("    comName=").append(getComName()).append(separator);
        str.append("    csCityCode=").append(getCsCityCode()).append(separator);
        str.append("    cityName=").append(getCityName()).append(separator);
        str.append("    aroundComName=").append(getAroundComName()).append(separator);
        str.append("    distance=").append(getDistance()).append(separator);
        str.append("    xlongitude=").append(getXlongitude()).append(separator);
        str.append("    ylatitude=").append(getYlatitude()).append(separator);
        str.append("    unitPrice=").append(getUnitPrice()).append(separator);
        str.append("    sourceChannel=").append(getSourceChannel()).append(separator);
        str.append("    status=").append(getStatus()).append(separator);
        str.append("    createTime=").append(getCreateTime()).append(separator);
        str.append("    lastUpdateTime=").append(getLastUpdateTime()).append(lineSeparator);
        str.append("}").append(lineSeparator);
        return str.toString();
    }
}
