package com.example.wellsfergobe.controller.apiResponseDto;

import com.example.wellsfergobe.entities.FileDetails;
import org.apache.tomcat.jni.File;

public class FileUploadRespDto {

    private String fileName;
    private Long fileId;
    private String errorMsg;

    public FileUploadRespDto(Builder builder){
        fileName = builder.fileName;
        fileId = builder.fileId;
        errorMsg = builder.errorMsg;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        if(errorMsg!=null){
            sb.append("{\"error\":\"").append(errorMsg).append("\"}");
            return sb.toString();
        }

        sb.append("{").append(System.lineSeparator());
        sb.append("\"fileName\":\"").append(fileName).append("\",").append(System.lineSeparator());
        sb.append("\"fileId\":\"").append(fileId).append("\"").append(System.lineSeparator());
        sb.append("}").append(System.lineSeparator());

        return sb.toString();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String fileName;
        private Long fileId;
        private String errorMsg=null;

        public Builder setFileDetails(FileDetails fileDetails){
            this.fileName = fileDetails.getName();
            this.fileId = fileDetails.getId();
            return this;
        }

        public Builder setErrorMsg(String errorMsg){
            this.errorMsg = errorMsg;
            return this;
        }

        public FileUploadRespDto build(){
            return new FileUploadRespDto(this);
        }
    }
}
