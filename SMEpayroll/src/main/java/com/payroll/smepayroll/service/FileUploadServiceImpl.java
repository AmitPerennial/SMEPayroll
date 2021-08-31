package com.payroll.smepayroll.service;

import com.payroll.smepayroll.exception.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Value("${file.uploadDirectory}")
    private String filePath;

    public List<List<String>> parseExcelFile(MultipartFile multipartFile) throws IOException {

        List<List<String>> employeeEntityList = new ArrayList<>();
        if(multipartFile.isEmpty() || multipartFile.getContentType().isEmpty()){
            throw new FileNotFoundException("File Is Empty Pls Check");
        }
        File fileUpload = new File(filePath+ multipartFile.getOriginalFilename());
        DataFormatter formatter = new DataFormatter();

        if (multipartFile.getOriginalFilename().endsWith(".xls") || multipartFile.getOriginalFilename().endsWith(".xlsx")
                || multipartFile.getOriginalFilename().endsWith(".csv")) {
            XSSFWorkbook workbook = null;
            try {
                FileInputStream inputStream = new FileInputStream(fileUpload);
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();
            for (int r = 1; r < rows-1; r++) {
                Row currentRow = sheet.getRow(r);
                List<String> fileList = new ArrayList<>();
                for (int col = 0; col < 10; col++) {
                    Cell cell = currentRow.getCell(col);
                    String excelFileData = formatter.formatCellValue(cell);
                    fileList.add(excelFileData);
                }
                employeeEntityList.add(fileList);
            }
        }
        return employeeEntityList;
    }
}
