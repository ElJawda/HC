
package com.shc.SHC_SS.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("IsRequired")
    @Expose
    private Boolean isRequired;
    @SerializedName("ImageName")
    @Expose
    private String imageName;
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
    public Language() {
    }

    /**
     * 
     * @param modifiedByID
     * @param isRequired
     * @param imageName
     * @param name
     * @param code
     * @param createDate
     * @param iD
     * @param updateDate
     */
    public Language(Integer iD, String name, String code, Boolean isRequired, String imageName, Object createDate, Object updateDate, Object modifiedByID) {
        super();
        this.iD = iD;
        this.name = name;
        this.code = code;
        this.isRequired = isRequired;
        this.imageName = imageName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.modifiedByID = modifiedByID;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
