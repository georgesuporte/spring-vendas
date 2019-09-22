package com.vendas.model.dto.pedidos;

import java.util.Date;

import com.vendas.entity.ClienteEntity;

import lombok.Data;

@Data
public class PedidosDto {
    private Long  idPedido;
    private Date data;
    private ClienteEntity idCliente;
    private String status;
    private String sessao;
}