
package com.vendas.repository;

import com.vendas.entity.CategoriaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRespository extends JpaRepository<CategoriaEntity, Long> {
}