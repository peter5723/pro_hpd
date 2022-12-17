package com.zju666.pro_hpd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zju666.pro_hpd.pojo.DocUser;
@Mapper
public interface DocUserMapper {
    List<DocUser> selectAllUser();

    DocUser selectById(Integer id);
    
    int insert(DocUser docUser);

    int delete(Integer id);

    int update(DocUser docUser);

}
