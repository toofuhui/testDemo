package com.hui.serviceimpl;

import com.hui.mapper.DistMapper;
import com.hui.pojo.dict.Area;
import com.hui.pojo.dict.City;
import com.hui.pojo.dict.Province;

import com.hui.service.DistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistServiceImpl implements DistService {
    @Autowired
    private DistMapper distMapper;

    @Override
    public List<Province> getProvinceList() {
        return distMapper.getProvinceList();
    }

    @Override
    public List<City> getCityList(String provinceCode) {
        return distMapper.getCityList(provinceCode);
    }

    @Override
    public List<Area> getAreaList(String cityCode) {
        return distMapper.getAreaList(cityCode);
    }
}
