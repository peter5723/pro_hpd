package com.zju666.pro_hpd.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zju666.pro_hpd.mapper.DocUserMapper;
import com.zju666.pro_hpd.pojo.DocUser;
import com.zju666.pro_hpd.service.DocUserService;
@Service
public class DocUserServiceImpl implements DocUserService{
    @Autowired
    private DocUserMapper docUserMapper;

    @Override
    public int deleteUser(Integer id) {
        docUserMapper.delete(id);
        // TODO Auto-generated method stub 异常处理
        return 0;
    }

    @Override
    public int insertDocUser(DocUser docUser) {
        docUserMapper.insert(docUser);
        // TODO 异常处理
        return 0;
    }

    @Override
    public List<DocUser> selectAllUser() {
        // TODO Auto-generated method stub 下同上
        return docUserMapper.selectAllUser();
    }

    @Override
    public DocUser selectUserByID(Integer id) {
        // TODO Auto-generated method stub
        return docUserMapper.selectById(id);
    }

    @Override
    public int updateUser(DocUser docUser) {
        docUserMapper.update(docUser);
        // TODO Auto-generated method stub
        return 0;
    }

    
}
    

    

