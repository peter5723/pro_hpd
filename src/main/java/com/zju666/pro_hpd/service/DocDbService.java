package com.zju666.pro_hpd.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zju666.pro_hpd.pojo.DocFile;
//对应的数据库操作接口
public interface DocDbService {
    public void insertRecord(String username,String url, MultipartFile file);

    public DocFile selectByName(String docName);
    
    public List<DocFile> selectAll();

    public void  deleteByName(String docName);
}
