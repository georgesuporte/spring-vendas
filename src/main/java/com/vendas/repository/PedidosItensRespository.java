
package com.vendas.repository;

import com.vendas.entity.PedidosItensEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosItensRespository extends JpaRepository<PedidosItensEntity, Long> {
}