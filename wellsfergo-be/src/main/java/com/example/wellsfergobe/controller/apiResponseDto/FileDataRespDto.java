package com.example.wellsfergobe.controller.apiResponseDto;

import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;

import java.util.List;

public class FileDataRespDto {
    private String fileName;
    private List<FileData> dataSet;

    public FileDataRespDto(FileDetails fileDetails, List<FileData> dataList){
        fileName = fileDetails.getName();
        this.dataSet = dataList;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("{\"fileName\":\"").append(fileName).append("\",").append(System.lineSeparator());
        sb.append("\"dataSet\":").append(dataSet.toString()).append("}");

        return sb.toString();
    }
}
