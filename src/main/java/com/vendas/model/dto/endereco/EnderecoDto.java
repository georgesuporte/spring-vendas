package com.vendas.model.dto.endereco;

import lombok.Data;

@Data
public class EnderecoDto {

    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

}