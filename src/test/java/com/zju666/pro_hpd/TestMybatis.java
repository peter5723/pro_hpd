package com.zju666.pro_hpd;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.zju666.pro_hpd.mapper.DocUserMapper;
import com.zju666.pro_hpd.pojo.DocUser;

public class TestMybatis {
    @Test
    void testCRUD() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3执行SQL语句
        DocUserMapper userMapper1 = sqlSession.getMapper(DocUserMapper.class);
        List<DocUser> users = userMapper1.selectAllUser();
        System.out.println(users);

        DocUser user1 = new DocUser(3, "hello", "hi");
        userMapper1.insert(user1);
        users = userMapper1.selectAllUser();
        System.out.println(users);
        
        DocUser user2 = new DocUser(3, "123", "hiff");
        userMapper1.update(user2);
        DocUser user = userMapper1.selectById(3);
        System.out.println(user);

        userMapper1.delete(3);
        users = userMapper1.selectAllUser();
        System.out.println(users);
        sqlSession.close();
    }
}
