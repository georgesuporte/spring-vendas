
package com.vendas.repository;

import com.vendas.entity.EnderecoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRespository extends JpaRepository<EnderecoEntity, Long> {
}