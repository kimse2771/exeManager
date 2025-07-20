package com.example.exemanager.exeManager.service;

import com.example.exemanager.exeManager.dto.FixedExtensionDTO;
import com.example.exemanager.exeManager.entity.CustomExtension;
import com.example.exemanager.exeManager.entity.FixedExtension;

import java.util.List;

public interface ExtensionService {



    List<FixedExtension> getFixedExtensions();
    void updateFixedExtensions(List<FixedExtensionDTO> exts);
    List<CustomExtension> getCustomExtensions();
    void addCustomExtension(String ext);
    void deleteCustomExtension(String ext);
}
