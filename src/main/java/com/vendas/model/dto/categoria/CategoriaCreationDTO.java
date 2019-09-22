package com.vendas.model.dto.categoria;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CategoriaCreationDTO {
    
    private Long id;
    
    @NotNull
    private String nomeCategoria;
}