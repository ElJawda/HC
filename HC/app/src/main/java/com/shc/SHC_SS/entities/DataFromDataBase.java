
package com.shc.SHC_SS.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataFromDataBase {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("check_uploaded")
    @Expose
    private Integer checkUploaded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataFromDataBase() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param checkUploaded
     */
    public DataFromDataBase(Integer id, String name, Integer checkUploaded) {
        super();
        this.id = id;
        this.name = name;
        this.checkUploaded = checkUploaded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCheckUploaded() {
        return checkUploaded;
    }

    public void setCheckUploaded(Integer checkUploaded) {
        this.checkUploaded = checkUploaded;
    }

}
