package com.zju666.pro_hpd.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.zju666.pro_hpd.pojo.DocFile;
import com.zju666.pro_hpd.service.FilesStorageService;

@Controller
public class DocIndexController {

    @Autowired
    FilesStorageService storageService;

    @GetMapping("/doc_index")
    public String homepage() {
        return "redirect:/files";
    }

    @GetMapping("/files/new")
    public String newFile(Model Model) {
        return "upload_form";
    }

    @PostMapping("/files/upload")
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file) {
        String message = "";

        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }

        return "upload_form";
        
    }

    @GetMapping("/files")
    public String getListFiles(Model model) {
        List<DocFile> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(DocIndexController.class, "getFile", path.getFileName().toString()).build()
                    .toString();

            return new DocFile(filename, url);//TODO 到时候改一下，yinweis大概率不用这种方式了
        }).collect(Collectors.toList());

        model.addAttribute("files", fileInfos);

        return "files";

    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
