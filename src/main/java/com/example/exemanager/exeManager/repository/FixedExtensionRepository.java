package com.example.exemanager.exeManager.repository;

import com.example.exemanager.exeManager.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface FixedExtensionRepository extends JpaRepository<FixedExtension,Long> {

    /** 확장자 이름으로 검색 **/
    Optional<FixedExtension> findByExt(String ext);

}
