package com.vendas.model.dto.endereco;

import com.vendas.entity.ClienteEntity;

import lombok.Data;

@Data
public class EnderecoCreationDTO {
    private Long idEndereco;
    private ClienteEntity idCliente;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

}