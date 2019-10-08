package com.hui.mapper;



import com.hui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper extends BaseMapper<User> {
   /* User findUserById(int id);
    List<User> getUserList();
    void add(User user);
    void delete(Integer id);
    void update(User user);*/
}
