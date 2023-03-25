package com.example.wellsfergobe.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class FileDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDateTime uploadedOn;
    private String fileType;

    public FileDetails(MultipartFile multipartFile){
        fileType = multipartFile.getContentType();
        name = multipartFile.getOriginalFilename();
        uploadedOn = LocalDateTime.now();

        log.info("FileName:{}, fileType:{}, uploadedOn:{}", name, fileType, uploadedOn);
    }

    public static FileDetails getNullInstance(){
        FileDetails fileDetails = new FileDetails();
        fileDetails.setName("Null");
        fileDetails.setFileType("Null");
        return fileDetails;
    }

    public boolean isNull(){
        if(name.equals("Null") && fileType.equals("Null"))
            return true;
        return false;
    }
}
