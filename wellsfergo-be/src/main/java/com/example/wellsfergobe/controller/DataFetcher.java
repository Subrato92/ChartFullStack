package com.example.wellsfergobe.controller;

import com.example.wellsfergobe.controller.apiResponseDto.FileDataRespDto;
import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;
import com.example.wellsfergobe.services.DataFetchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataFetcher {

    @Autowired
    private DataFetchingService dataFetchingService;

    @GetMapping(path = "/all")
    public ResponseEntity<String> getAll(@RequestParam("fileId") Long id){

        log.info("Received Request... @getAll");

        FileDetails fileDetails = dataFetchingService.getFileDetails(id);

        if(fileDetails.isNull())
            return ResponseEntity.badRequest().body("Invalid FileId : "+id);

        List<FileData> dataList = dataFetchingService.getAllByFileDetails(fileDetails, Sort.by(Sort.Direction.ASC, "id"));

        return ResponseEntity.ok().body(new FileDataRespDto(fileDetails, dataList).toString());
    }
}
