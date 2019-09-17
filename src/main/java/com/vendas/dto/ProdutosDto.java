package com.vendas.dto;
import lombok.Data;

@Data
public class ProdutosDto {
    private long idCategoria;
    private String produto;
    private String preco;
    private String quantidade;
    private String descricao;
    private String foto;
}