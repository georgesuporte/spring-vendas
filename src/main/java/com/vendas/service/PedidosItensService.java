package com.vendas.service;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.PedidosItensEntity;
import com.vendas.repository.PedidosItensRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class PedidosItensService {
    private final PedidosItensRespository PedidosItensRespository;

    public List<PedidosItensEntity> findAll() {
        return PedidosItensRespository.findAll();
    }

    public Optional<PedidosItensEntity> findById(Long id) {
        return PedidosItensRespository.findById(id);
    }

    public PedidosItensEntity save(PedidosItensEntity stock) {
        return PedidosItensRespository.save(stock);
    }

    public void deleteById(Long id) {
        PedidosItensRespository.deleteById(id);
    }
}