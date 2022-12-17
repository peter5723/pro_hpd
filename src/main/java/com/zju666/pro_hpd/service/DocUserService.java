package com.zju666.pro_hpd.service;

import java.util.List;

import com.zju666.pro_hpd.pojo.DocUser;

public interface DocUserService {
    int insertDocUser(DocUser docUser);

    DocUser selectUserByID(Integer id);

    List<DocUser> selectAllUser();

    int updateUser(DocUser docUser);

    int deleteUser(Integer id);

}
