package com.zju666.pro_hpd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zju666.pro_hpd.pojo.DocFile;
@Mapper
public interface DocFileMapper {
    List<DocFile> selectAllFile();

    DocFile selectByName(String docname);

    void insertRecord(DocFile docFile);

    void deleteRecord(String docname);

    void updateRecord(DocFile docFile);
}
