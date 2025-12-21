package com.Khewang.blogging.service.Impl;

import com.Khewang.blogging.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file name
        String name = file.getOriginalFilename();

        String randomId = java.util.UUID.randomUUID().toString();
        // String fileName1 = randomId.concat(name);
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf('.')));

        //fullpath
        String filepath = path + java.io.File.separator + fileName1;



        //checking if folder is created or not
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        //file copy
        //first target and source
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);

        return is;
    }
}
