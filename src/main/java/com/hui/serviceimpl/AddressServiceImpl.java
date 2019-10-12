package com.hui.serviceimpl;

import com.hui.mapper.AddressMapper;
import com.hui.mapper.DistMapper;
import com.hui.pojo.Address;
import com.hui.pojo.dict.Province;
import com.hui.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private DistMapper distMapper;
    @Override
    public void addAddress(Address address) {
        String provinceName=distMapper.getProvinceNameByCode(address.getRecvProvince());

        String cityName=distMapper.getCityNameByCode(address.getRecvArea());

        String areaName=distMapper.getAreaNameByCode(address.getRecvArea());

        String district=provinceName+","+cityName+","+areaName;
        address.setRecvDistrict(district);
        addressMapper.insert(address);
    }
}
