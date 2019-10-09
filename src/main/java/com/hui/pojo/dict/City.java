package com.hui.pojo.dict;

import io.swagger.models.auth.In;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = 3239256531619340290L;
    private Integer id;
    private String cityCode;
    private String cityName;
    private String provinceCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
