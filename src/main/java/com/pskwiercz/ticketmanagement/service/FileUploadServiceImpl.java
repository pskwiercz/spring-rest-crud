package com.pskwiercz.ticketmanagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file.upload.target.directory}")
    private String TARGET_DIRECTORY;

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.isEmpty()) {
            throw new IOException("File is empty " + fileName);
        }

        try {
            Path location = Paths.get(TARGET_DIRECTORY);
            Files.createDirectories(location);
            Files.copy(file.getInputStream(), location.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("File Upload Error : " + fileName);
        }
    }
}
