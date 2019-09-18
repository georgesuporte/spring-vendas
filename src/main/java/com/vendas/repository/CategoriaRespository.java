
package com.vendas.repository;

import com.vendas.entity.CategoriaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoriaRespository extends JpaRepository<CategoriaEntity, Long> {
}