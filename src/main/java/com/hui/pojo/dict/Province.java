package com.hui.pojo.dict;

import java.io.Serializable;

public class Province implements Serializable {
    private static final long serialVersionUID = -4709435898599347274L;
    private Integer id;
    private String provinceCode;
    private String provinceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
