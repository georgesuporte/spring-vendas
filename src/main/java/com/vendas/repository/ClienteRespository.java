
package com.vendas.repository;

import com.vendas.entity.ClienteEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<ClienteEntity, Long> {
}