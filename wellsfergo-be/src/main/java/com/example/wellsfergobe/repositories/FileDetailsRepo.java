package com.example.wellsfergobe.repositories;

import com.example.wellsfergobe.entities.FileDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDetailsRepo extends JpaRepository<FileDetails, Long> {
}
