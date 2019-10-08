package com.hui.serviceimpl;
import com.hui.mapper.BaseMapper;
import com.hui.mapper.UserInfoMapper;
import com.hui.mapper.UserMapper;
import com.hui.pojo.User;
import com.hui.pojo.UserInfo;
import com.hui.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    protected BaseMapper<UserInfo> getMapper() {
        return userInfoMapper;
    }
}

