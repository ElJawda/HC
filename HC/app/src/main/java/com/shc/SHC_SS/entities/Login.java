
package com.shc.SHC_SS.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("IdentityNum")
    @Expose
    private String identityNum;
    @SerializedName("MobileNum")
    @Expose
    private Object mobileNum;
    @SerializedName("RoleID")
    @Expose
    private Integer roleID;
    @SerializedName("CityName")
    @Expose
    private Object cityName;
    @SerializedName("RegionName")
    @Expose
    private Object regionName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Login() {
    }

    /**
     * 
     * @param mobileNum
     * @param email
     * @param cityName
     * @param regionName
     * @param identityNum
     * @param userName
     * @param fullName
     * @param roleID
     * @param password
     * @param iD
     */
    public Login(Integer iD, String userName, String fullName, String password, String email, String identityNum, Object mobileNum, Integer roleID, Object cityName, Object regionName) {
        super();
        this.iD = iD;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.identityNum = identityNum;
        this.mobileNum = mobileNum;
        this.roleID = roleID;
        this.cityName = cityName;
        this.regionName = regionName;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public Object getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(Object mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Object getCityName() {
        return cityName;
    }

    public void setCityName(Object cityName) {
        this.cityName = cityName;
    }

    public Object getRegionName() {
        return regionName;
    }

    public void setRegionName(Object regionName) {
        this.regionName = regionName;
    }

}
