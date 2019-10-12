package com.hui.controller;

import com.hui.pojo.Address;
import com.hui.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("addrss测试controller")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value="增加地址信息")
    public void add(@RequestBody Address address){
        addressService.addAddress(address);
    }
}
