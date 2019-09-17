package com.vendas.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

}