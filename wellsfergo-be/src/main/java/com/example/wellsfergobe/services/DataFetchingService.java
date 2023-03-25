package com.example.wellsfergobe.services;

import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;
import com.example.wellsfergobe.repositories.FileDataRepo;
import com.example.wellsfergobe.repositories.FileDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataFetchingService {

    @Autowired
    private FileDetailsRepo fileDetailsRepo;

    @Autowired
    private FileDataRepo fileDataRepo;

    public FileDetails getFileDetails(Long id){
        Optional<FileDetails> optionalFileDetails = fileDetailsRepo.findById(id);

        if(optionalFileDetails.isPresent())
            return optionalFileDetails.get();

        return FileDetails.getNullInstance();
    }

    public List<FileData> getAllByFileDetails(FileDetails fileDetails, Sort sort){
        List<FileData> fileDataList = fileDataRepo.findAllByFileDetailsId(fileDetails.getId(), sort);

        return fileDataList;
    }

}
