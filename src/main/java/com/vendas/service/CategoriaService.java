package com.vendas.service;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.CategoriaEntity;
import com.vendas.repository.CategoriaRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class CategoriaService {
    private final CategoriaRespository CategoriaRespository;

    public List<CategoriaEntity> findAll() {
        return CategoriaRespository.findAll();
    }

    public Optional<CategoriaEntity> findById(Long id) {
        return CategoriaRespository.findById(id);
    }

    public CategoriaEntity save(CategoriaEntity stock) {
        return CategoriaRespository.save(stock);
    }

    public void deleteById(Long id) {
        CategoriaRespository.deleteById(id);
    }

	public List<CategoriaEntity> findByCategoriaContaining(String nomeCategoria) {
        return CategoriaRespository.findByCategoriaContaining(nomeCategoria);
        
	}
}