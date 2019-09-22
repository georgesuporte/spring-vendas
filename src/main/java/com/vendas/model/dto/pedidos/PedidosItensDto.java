package com.vendas.model.dto.pedidos;

import lombok.Data;

@Data
public class PedidosItensDto {
    private PedidosDto idPedidos;
    private int quantidade;
    private double valor;
    private double subtotal;
}