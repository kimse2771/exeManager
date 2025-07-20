package com.example.exemanager.exeManager.service;


import com.example.exemanager.exeManager.dto.FixedExtensionDTO;
import com.example.exemanager.exeManager.entity.CustomExtension;
import com.example.exemanager.exeManager.entity.FixedExtension;
import com.example.exemanager.exeManager.repository.CustomExtensionRepository;
import com.example.exemanager.exeManager.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExtensionServiceImpl implements ExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;


    /** 고정 확장자 목록 불러오기 **/
    public List<FixedExtension> getFixedExtensions() {
        return fixedExtensionRepository.findAll();
    }

    /**고정 확장자 체크/해제 상태 저장 **/
    @Transactional
    public void updateFixedExtensions(List<FixedExtensionDTO> exts) {
        for (FixedExtensionDTO ext : exts) {
            FixedExtension existing = fixedExtensionRepository.findByExt(ext.getExt())
                    .orElseThrow(() -> new RuntimeException("존재하지 않는 확장자: " + ext.getExt()));
            existing.update(ext);
            fixedExtensionRepository.save(existing);
        }
    }


    /** 커스텀 확장자 목록 불러오기**/
    public List<CustomExtension> getCustomExtensions() {
        return customExtensionRepository.findAll();
    }

    /** 커스텀 확장자 추가**/
    @Transactional
    public void addCustomExtension(String ext) {
        if (ext.length() > 20) throw new IllegalArgumentException("20자 초과 불가");
        if (customExtensionRepository.existsByExt(ext)) return;
        if (customExtensionRepository.count() >= 200) throw new IllegalStateException("200개 초과");
        customExtensionRepository.save(
                CustomExtension.builder()
                        .ext(ext)
                        .build()
        );
    }

    /** 커스텀 확장자 삭제**/
    public void deleteCustomExtension(String ext) {
        customExtensionRepository.findByExt(ext).ifPresent(customExtensionRepository::delete);
    }

}
