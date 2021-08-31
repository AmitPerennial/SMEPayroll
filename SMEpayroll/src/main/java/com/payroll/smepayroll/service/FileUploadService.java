package com.payroll.smepayroll.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    List<List<String>> parseExcelFile(MultipartFile multipartFile) throws IOException;
}
