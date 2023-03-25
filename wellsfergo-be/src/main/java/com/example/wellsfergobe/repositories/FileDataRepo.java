package com.example.wellsfergobe.repositories;

import com.example.wellsfergobe.entities.FileData;
import com.example.wellsfergobe.entities.FileDetails;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileDataRepo extends JpaRepository<FileData, Long> {

    List<FileData> findAllByFileDetailsId(Long fileDetailsId, Sort sort);
}
