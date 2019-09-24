
package com.vendas.repository;

import java.util.List;

import com.vendas.entity.CategoriaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRespository extends JpaRepository<CategoriaEntity, Long> {

	List<CategoriaEntity> findByCategoriaContaining(String nomeCategoria);
}