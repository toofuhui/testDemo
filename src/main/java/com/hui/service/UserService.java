package com.hui.service;

import com.hui.dto.UserDto;
import com.hui.pojo.User;
import com.hui.vo.UserVO;

import java.util.List;

public interface UserService extends BaseService<User>{
   /* //根据id查找用户信息
    User getUserById(Integer id);
    List<User> getUserList();
    void add(User user);
    void delete(Integer id);
    void update(User user);*/
    //List<UserVO> getList();
    void save(UserDto userDto);
    void sendsms(String mobile);

    void register(User user, String code);

    User login(User user);
}
