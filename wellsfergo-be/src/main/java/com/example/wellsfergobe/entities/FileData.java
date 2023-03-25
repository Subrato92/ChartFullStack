package com.example.wellsfergobe.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private FileDetails fileDetails;
    private float x;
    private float y;

    public FileData(FileDetails fileDetails, float x, float y){
        this.fileDetails = fileDetails;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\"").append("id").append("\":").append(id).append(",").append(System.lineSeparator());
        sb.append("\"").append("x").append("\":").append(x).append(",").append(System.lineSeparator());
        sb.append("\"").append("y").append("\":").append(y).append("}").append(System.lineSeparator());

        return sb.toString();
    }

}
