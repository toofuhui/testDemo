package com.hui.mapper;

import com.hui.pojo.dict.Area;
import com.hui.pojo.dict.City;
import com.hui.pojo.dict.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DistMapper {
    List<Province> getProvinceList();

    List<City> getCityList(String provinceCode);

    List<Area> getAreaList(String cityCode);

    String getProvinceNameByCode(String provinceCode);

    String getCityNameByCode(String cityCode);

    String getAreaNameByCode(String areaCode);
}
