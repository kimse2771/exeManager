package com.example.exemanager.exeManager.entity;

import com.example.exemanager.exeManager.dto.FixedExtensionDTO;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixed_extension")
public class FixedExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ext;

    @Column(nullable = false)
    private boolean checked;


    public void update(FixedExtensionDTO dto){
        this.checked = dto.isChecked();
    }

}