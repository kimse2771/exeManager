package com.example.exemanager.exeManager.dto;


import lombok.*;

@Getter
@Setter
@Data // Lombok 사용 시
@NoArgsConstructor
@AllArgsConstructor
public class FixedExtensionDTO {

    private String ext;

    private boolean checked;
}
