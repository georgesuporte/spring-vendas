
package com.vendas.repository;

import java.util.List;

import com.vendas.entity.EnderecoEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRespository extends JpaRepository<EnderecoEntity, Long> {

	List<EnderecoEntity> findByRuaContainingOrBairroContaining(String rua, String bairro);

}