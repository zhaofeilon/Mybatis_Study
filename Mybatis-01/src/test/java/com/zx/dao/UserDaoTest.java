package com.zx.dao;
import com.zx.pojo.User;
import com.zx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> list = mapper.getUserLike("%李%");
        for (User u : list)
        {
            System.out.println(u);
        }
        sqlSession.close();
    }
    @Test
    public void test(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.getUserList();
        for (User user : list)
        {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public  void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        sqlSession.close();

    }
    //增删改要添加事务
   @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
       int res= mapper.addUser(new User(4,"哈哈","dfafafaag"));
       if (res>0){
           System.out.println("插入成功!");
       }
       sqlSession.commit();
        sqlSession.close();
    }
    //修改用户
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(4,"呵呵","143434"));
        sqlSession.commit();
        sqlSession.close();
    }
    //删除用户
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deletUser(3);
        sqlSession.commit();
        sqlSession.close();
    }
}
