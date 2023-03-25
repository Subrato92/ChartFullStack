package com.example.wellsfergobe.controller;

import com.example.wellsfergobe.controller.apiResponseDto.FileUploadRespDto;
import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;
import com.example.wellsfergobe.services.FileUploadingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/load")
public class DataLoader {

    @Autowired
    private FileUploadingService fileUploadingService;
    @PostMapping(path = "/csv", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile multipartFile){

        log.info("Received Request... @uploadCsv");
        try {

            if(!multipartFile.getContentType().equals("text/csv"))
                return ResponseEntity
                        .badRequest()
                        .body(
                            FileUploadRespDto
                                .getBuilder()
                                .setErrorMsg("Invalid file-type - ".concat(multipartFile.getContentType()))
                                .build().toString());

            FileDetails fileDetails = new FileDetails(multipartFile);
            fileUploadingService.addFileMeta(fileDetails);

            String fileData = new String(multipartFile.getBytes());
            log.debug("Data: {}", fileData);
            String[] entries = fileData.split("\\n");

            ArrayList<FileData> fileDataList = new ArrayList<>();
            for(int i=1; i<entries.length; i++){
                log.debug("Entry:{}", entries[i]);
                String[] elements = entries[i].split(",");
                FileData fData = new FileData(fileDetails,
                        Float.parseFloat(elements[0].trim()),
                        Float.parseFloat(elements[1].trim()));
                fileDataList.add(fData);
            }

            fileUploadingService.addFileDataList(fileDataList);

            return ResponseEntity
                    .ok()
                    .body(FileUploadRespDto
                        .getBuilder()
                        .setFileDetails(fileDetails)
                        .build().toString());
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(FileUploadRespDto
                    .getBuilder()
                    .setErrorMsg(ex.getMessage())
                    .build().toString());
        }
    }

}