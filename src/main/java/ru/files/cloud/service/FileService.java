package ru.files.cloud.service;

import org.springframework.web.multipart.MultipartFile;
import ru.files.cloud.dto.*;
import ru.files.cloud.model.FileBody;


import java.util.List;

public interface FileService {

    void uploadFile (MultipartFile file, String fileName);

    FileDto downloadFile(String fileName);

    void editFileName(String fileName, FileBody name);

    void deleteFile(String fileName);

    List<FileDto> getAllFiles(int limit);

}
