package com.vendas.model.dto.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ClienteUpdatePasswordDTO {
    private Long id;
    private String senha;
}