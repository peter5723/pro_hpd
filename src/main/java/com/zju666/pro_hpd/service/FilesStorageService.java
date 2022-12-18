package com.zju666.pro_hpd.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
    // init初始化文件夹
    public void init();

    // 保存文件到文件夹（上传的工作）
    public void save(MultipartFile file);

    // 加载文件
    public Resource load(String filename);

    // 删除所有文件
    public void deleteAll();

    // 加载路径下所有文件，用于列表文件信息用的
    public Stream<Path> loadAll();
}
