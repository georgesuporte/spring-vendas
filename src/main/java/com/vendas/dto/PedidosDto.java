package com.vendas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PedidosDto {
    private Date data;
    private ClienteDto idCliente;
    private String status;
    private String sessao;
}