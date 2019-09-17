package com.vendas.dto;

import lombok.Data;

@Data
public class PedidosItensDto {
    private long idProduto;
    private String produto;
    private int quantidade;
    private double valor;
    private String subtotal;
}