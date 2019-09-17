package com.vendas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PedidosDto {
    private Date data;
    private Long idCliente;
    private String status;
    private String sessao;
}