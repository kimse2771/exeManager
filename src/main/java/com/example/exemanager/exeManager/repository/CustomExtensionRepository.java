package com.example.exemanager.exeManager.repository;

import com.example.exemanager.exeManager.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



public interface CustomExtensionRepository extends JpaRepository<CustomExtension,Long> {

    boolean existsByExt(String ext);

    Optional<CustomExtension> findByExt(String ext);


}
