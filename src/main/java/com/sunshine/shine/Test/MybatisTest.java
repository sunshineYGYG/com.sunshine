package com.sunshine.shine.Test;

import com.sunshine.shine.dao.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {
    @Test
    public  void testMybatis(){
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession();
        String statement ="com.sunshine.shine.mapper.UserMapper.selectOneUser";
        User o = session.selectOne(statement,2);
        System.out.println(o.getId()+" name="+o.getName()+" sex="+o.getSex());
    }
}
