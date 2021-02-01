package com.zx.dao;

import com.zx.pojo.User;
import com.zx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class demo {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserDao UserD = sqlSession.getMapper(UserDao.class);
        List<com.zx.pojo.User> users = UserD.getUserList();
        for (User  user :users )
        {
            System.out.println(user);
        }

    }
}
