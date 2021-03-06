package com.vendas.model.dto.cliente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vendas.model.dto.endereco.EnderecoResponseDTO;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ClienteResponseDTO {
    private Long idCliente;
    private String nome;
    private String email;
    private List<EnderecoResponseDTO> endereco;
}