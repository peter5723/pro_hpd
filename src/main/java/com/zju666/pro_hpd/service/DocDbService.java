package com.zju666.pro_hpd.service;

import org.springframework.web.multipart.MultipartFile;
//对应的数据库操作接口
public interface DocDbService {
    public void insertRecord(String username, MultipartFile file);

    public void selectByName(String DocName);
    
    public void selectAll();

    public void deleteByName(String DocName);
}
