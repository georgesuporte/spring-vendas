package com.vendas.dto;

import lombok.Data;

@Data
public class ClienteDto {

    private String nome;
    private String email;
    private String senha;
    private Long  idEndereco;

}