package com.example.wellsfergobe.services;

import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;
import com.example.wellsfergobe.repositories.FileDataRepo;
import com.example.wellsfergobe.repositories.FileDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class FileUploadingService {
    @Autowired
    private FileDetailsRepo fileDetailsRepo;

    @Autowired
    private FileDataRepo fileDataRepo;

    public boolean addFileMeta(FileDetails fileDetails){
        try {
            fileDetailsRepo.save(fileDetails);
        } catch (Exception ex){
            return false;
        }
        log.info("FileDetails saved in dB...");
        return true;
    }

    public boolean addFileDataList(ArrayList<FileData> fileDataList){
        try {
            fileDataRepo.saveAll(fileDataList);
        } catch (Exception ex){
            return false;
        }
        log.info("FileData List saved in dB...");
        return true;
    }
}
