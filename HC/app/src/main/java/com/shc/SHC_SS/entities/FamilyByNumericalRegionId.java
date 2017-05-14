
package com.shc.SHC_SS.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FamilyByNumericalRegionId {

    @SerializedName("Responses")
    @Expose
    private List<Object> responses = null;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("NumericalAreaCode")
    @Expose
    private String numericalAreaCode;
    @SerializedName("FamilyNo")
    @Expose
    private Integer familyNo;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Center")
    @Expose
    private Integer center;
    @SerializedName("CenterName")
    @Expose
    private String centerName;
    @SerializedName("SubCity")
    @Expose
    private Integer subCity;
    @SerializedName("SubCityNo")
    @Expose
    private Integer subCityNo;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("HaraName")
    @Expose
    private String haraName;
    @SerializedName("HaraNo")
    @Expose
    private Integer haraNo;
    @SerializedName("Section")
    @Expose
    private Integer section;
    @SerializedName("BlockNo")
    @Expose
    private Integer blockNo;
    @SerializedName("BuildNo")
    @Expose
    private Integer buildNo;
    @SerializedName("UnitNo")
    @Expose
    private Integer unitNo;
    @SerializedName("GPSX")
    @Expose
    private String gPSX;
    @SerializedName("GPSY")
    @Expose
    private String gPSY;
    @SerializedName("CreateDate")
    @Expose
    private Object createDate;
    @SerializedName("UpdateDate")
    @Expose
    private Object updateDate;
    @SerializedName("ModifiedByID")
    @Expose
    private Object modifiedByID;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FamilyByNumericalRegionId() {
    }

    /**
     * 
     * @param gPSX
     * @param gPSY
     * @param centerName
     * @param cityName
     * @param numericalAreaCode
     * @param blockNo
     * @param subCity
     * @param subCityNo
     * @param iD
     * @param updateDate
     * @param section
     * @param responses
     * @param buildNo
     * @param center
     * @param haraName
     * @param haraNo
     * @param modifiedByID
     * @param name
     * @param createDate
     * @param unitNo
     * @param familyNo
     */
    public FamilyByNumericalRegionId(List<Object> responses, Integer iD, String numericalAreaCode, Integer familyNo, String name, Integer center, String centerName, Integer subCity, Integer subCityNo, String cityName, String haraName, Integer haraNo, Integer section, Integer blockNo, Integer buildNo, Integer unitNo, String gPSX, String gPSY, Object createDate, Object updateDate, Object modifiedByID) {
        super();
        this.responses = responses;
        this.iD = iD;
        this.numericalAreaCode = numericalAreaCode;
        this.familyNo = familyNo;
        this.name = name;
        this.center = center;
        this.centerName = centerName;
        this.subCity = subCity;
        this.subCityNo = subCityNo;
        this.cityName = cityName;
        this.haraName = haraName;
        this.haraNo = haraNo;
        this.section = section;
        this.blockNo = blockNo;
        this.buildNo = buildNo;
        this.unitNo = unitNo;
        this.gPSX = gPSX;
        this.gPSY = gPSY;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.modifiedByID = modifiedByID;
    }

    public List<Object> getResponses() {
        return responses;
    }

    public void setResponses(List<Object> responses) {
        this.responses = responses;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getNumericalAreaCode() {
        return numericalAreaCode;
    }

    public void setNumericalAreaCode(String numericalAreaCode) {
        this.numericalAreaCode = numericalAreaCode;
    }

    public Integer getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(Integer familyNo) {
        this.familyNo = familyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCenter() {
        return center;
    }

    public void setCenter(Integer center) {
        this.center = center;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Integer getSubCity() {
        return subCity;
    }

    public void setSubCity(Integer subCity) {
        this.subCity = subCity;
    }

    public Integer getSubCityNo() {
        return subCityNo;
    }

    public void setSubCityNo(Integer subCityNo) {
        this.subCityNo = subCityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHaraName() {
        return haraName;
    }

    public void setHaraName(String haraName) {
        this.haraName = haraName;
    }

    public Integer getHaraNo() {
        return haraNo;
    }

    public void setHaraNo(Integer haraNo) {
        this.haraNo = haraNo;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(Integer blockNo) {
        this.blockNo = blockNo;
    }

    public Integer getBuildNo() {
        return buildNo;
    }

    public void setBuildNo(Integer buildNo) {
        this.buildNo = buildNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getGPSX() {
        return gPSX;
    }

    public void setGPSX(String gPSX) {
        this.gPSX = gPSX;
    }

    public String getGPSY() {
        return gPSY;
    }

    public void setGPSY(String gPSY) {
        this.gPSY = gPSY;
    }

    public Object getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Object createDate) {
        this.createDate = createDate;
    }

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
        this.updateDate = updateDate;
    }

    public Object getModifiedByID() {
        return modifiedByID;
    }

    public void setModifiedByID(Object modifiedByID) {
        this.modifiedByID = modifiedByID;
    }

}
