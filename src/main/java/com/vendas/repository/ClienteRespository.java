
package com.vendas.repository;

import java.util.List;

import com.vendas.entity.ClienteEntity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<ClienteEntity, Long> {

	List<ClienteEntity> findByNomeContainingOrEmailContaining(String nomeCliente,String emailCliente );
}