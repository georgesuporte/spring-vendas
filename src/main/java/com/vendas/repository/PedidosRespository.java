
package com.vendas.repository;

import com.vendas.entity.PedidosEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRespository extends JpaRepository<PedidosEntity, Long> {
}