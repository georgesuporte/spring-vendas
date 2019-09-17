package com.vendas.service;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.ProdutosEntity;
import com.vendas.repository.ProdutosRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class ProdutosService {
    private final ProdutosRespository ProdutosRespository;

    public List<ProdutosEntity> findAll() {
        return ProdutosRespository.findAll();
    }

    public Optional<ProdutosEntity> findById(Long id) {
        return ProdutosRespository.findById(id);
    }

    public ProdutosEntity save(ProdutosEntity stock) {
        return ProdutosRespository.save(stock);
    }

    public void deleteById(Long id) {
        ProdutosRespository.deleteById(id);
    }
}