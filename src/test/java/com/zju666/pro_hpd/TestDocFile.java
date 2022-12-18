package com.zju666.pro_hpd;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import com.zju666.pro_hpd.mapper.DocFileMapper;
import com.zju666.pro_hpd.pojo.DocFile;

public class TestDocFile {
    @Test
    void testDocCRUD() throws IOException {
        String resource = "mybatis-configfordocfile.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3执行SQL语句
        DocFileMapper fileMapper1 = sqlSession.getMapper(DocFileMapper.class);
        List<DocFile> files = fileMapper1.selectAllFile();
        System.out.println(files);

        String a = "a.txt";
        DocFile docFile1 = fileMapper1.selectByName(a);
        System.out.println(docFile1);

        DocFile docFile3 = new DocFile(5,"v.tcg","kkk","hua","null",2);
        fileMapper1.insertRecord(docFile3);
        files = fileMapper1.selectAllFile();
        System.out.println(files);

        docFile3.setDocname("jfid.ds");
        fileMapper1.updateRecord(docFile3);
        files = fileMapper1.selectAllFile();
        System.out.println(files);

        fileMapper1.deleteRecord("jfid.ds");
        files = fileMapper1.selectAllFile();
        System.out.println(files);



        sqlSession.close();
    }

}
