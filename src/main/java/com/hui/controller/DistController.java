package com.hui.controller;

import com.hui.pojo.dict.Area;
import com.hui.pojo.dict.City;
import com.hui.pojo.dict.Province;
import com.hui.service.DistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("dist测试controller")
@RequestMapping("/dist")
public class DistController {
    @Autowired
    private DistService distService;
    @RequestMapping(value = "/get_province_list",method = RequestMethod.GET)
    @ApiOperation(value="查询省份")
    public List<Province> getProvinceList(){
        return distService.getProvinceList();
    }

    @RequestMapping(value = "/get_city_list/{provinceCode}",method = RequestMethod.GET)
    @ApiOperation(value="根据省份编码查询城市")
    public List<City> getCityList(@PathVariable("provinceCode") String provinceCode){
        return distService.getCityList(provinceCode);
    }

    @RequestMapping(value = "/get_area_list/{cityCode}",method = RequestMethod.GET)
    @ApiOperation(value="根据城市编码查询各个县区")
    public List<Area> getAreaList(@PathVariable String cityCode){
        return distService.getAreaList(cityCode);
    }
}
