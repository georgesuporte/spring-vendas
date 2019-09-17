package com.vendas.service;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.PedidosEntity;
import com.vendas.repository.PedidosRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class PedidosService {
    private final PedidosRespository PedidosRespository;

    public List<PedidosEntity> findAll() {
        return PedidosRespository.findAll();
    }

    public Optional<PedidosEntity> findById(Long id) {
        return PedidosRespository.findById(id);
    }

    public PedidosEntity save(PedidosEntity stock) {
        return PedidosRespository.save(stock);
    }

    public void deleteById(Long id) {
        PedidosRespository.deleteById(id);
    }
}