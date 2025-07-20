package com.example.exemanager.exeManager.controller;

import com.example.exemanager.exeManager.dto.FixedExtensionDTO;
import com.example.exemanager.exeManager.entity.CustomExtension;
import com.example.exemanager.exeManager.entity.FixedExtension;
import com.example.exemanager.exeManager.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ext")
public class ExtensionController {

  private final ExtensionService extensionService;

    @GetMapping("/fixed-exts")
    public List<FixedExtension> getFixed() {
        return extensionService.getFixedExtensions();
    }

    @PutMapping("/fixed-exts")
    public void updateFixed(@RequestBody List<FixedExtensionDTO> exts) {
        extensionService.updateFixedExtensions(exts);
    }

    @GetMapping("/custom-exts")
    public List<CustomExtension> getCustom() {
        return extensionService.getCustomExtensions();
    }

    @PostMapping("/custom-exts")
    public void addCustom(@RequestParam String ext) {
        extensionService.addCustomExtension(ext);
    }

    @DeleteMapping("/custom-exts")
    public void deleteCustom(@RequestParam String ext) {
        extensionService.deleteCustomExtension(ext);
    }
}