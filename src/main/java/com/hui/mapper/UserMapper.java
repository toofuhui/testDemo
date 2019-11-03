package com.hui.mapper;



import com.hui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
   /* User findUserById(int id);
    List<User> getUserList();
    void add(User user);
    void delete(Integer id);
    void update(User user);*/
   @Select("SELECT * FROM USER WHERE user_name=#{user_name}")
   User findUserByName(@Param("user_name") String user_name);
}
