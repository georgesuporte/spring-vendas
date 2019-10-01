package com.vendas.model.dto.cliente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vendas.model.dto.endereco.EnderecoCreationDTO;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ClienteCreationDTO {
    private Long idCliente;
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoCreationDTO> endereco;
     
}