package com.zx.dao;
import com.zx.pojo.User;
import java.util.List;
public interface UserDao {
    //模糊查询
    List<User> getUserLike(String value);
    //查询全部用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deletUser(int id);
}

