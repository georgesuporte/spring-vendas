package com.vendas.model.dto.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ClienteCreationDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
     

}