package com.zju666.pro_hpd.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.zju666.pro_hpd.controller.DocIndexController;
import com.zju666.pro_hpd.mapper.DocFileMapper;
import com.zju666.pro_hpd.pojo.DocFile;
import com.zju666.pro_hpd.service.DocDbService;
@Service
public class DocDbServiceImpl implements DocDbService{
    @Autowired
    private DocFileMapper docFileMapper;
    @Override
    public void deleteByName(String docName) {
        
        docFileMapper.deleteRecord(docName);
    }

    @Override
    public void insertRecord(String username, String url, MultipartFile file) {
        
        DocFile docFile1 = new DocFile(file.hashCode(), file.getOriginalFilename(), url, username, file.getOriginalFilename(), (int)file.getSize());

        docFileMapper.insertRecord(docFile1);
    }


    @Override
    public List<DocFile> selectAll() {
        
        return docFileMapper.selectAllFile();
    }

    @Override
    public DocFile selectByName(String docName) {
        return docFileMapper.selectByName(docName);
    }
    
}
