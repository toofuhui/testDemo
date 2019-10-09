package com.hui.service;

import com.hui.pojo.dict.Area;
import com.hui.pojo.dict.City;
import com.hui.pojo.dict.Province;

import java.util.List;

public interface DistService {
    List<Province> getProvinceList();

    List<City> getCityList(String provinceCode);

    List<Area> getAreaList(String cityCode);
}
