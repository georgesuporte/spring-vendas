package com.vendas.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.vendas.entity.EnderecoEntity;
import com.vendas.repository.EnderecoRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class EnderecoService {
    private final EnderecoRespository EnderecoRespository;

    public List<EnderecoEntity> findAll() {
        return EnderecoRespository.findAll();
    }

    public Optional<EnderecoEntity> findById(Long id) {
        return EnderecoRespository.findById(id);
    }

    public EnderecoEntity save(EnderecoEntity stock) {
        return EnderecoRespository.save(stock);
    }

    public void deleteById(Long id) {
        EnderecoRespository.deleteById(id);
    }

	public List<EnderecoEntity> findByRuaContainingOrBairroContaining(String rua, String bairro) {
		return EnderecoRespository.findByRuaContainingOrBairroContaining(rua, bairro);
	}
    @Transactional(rollbackOn = { Exception.class })
	public List<EnderecoEntity> saveAll(Collection<EnderecoEntity> enderecoList) {
		return EnderecoRespository.saveAll(enderecoList);
	}
}