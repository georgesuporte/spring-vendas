
package com.vendas.repository;

import com.vendas.entity.ProdutosEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRespository extends JpaRepository<ProdutosEntity, Long> {
}