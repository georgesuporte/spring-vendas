package com.vendas.model.dto.produtos;

import com.vendas.model.dto.categoria.CategoriaCreationDTO;

import lombok.Data;

@Data
public class ProdutosDto {
    private CategoriaCreationDTO idCategoria;
    private String produto;
    private String preco;
    private String quantidade;
    private String descricao;
    private String foto;
}