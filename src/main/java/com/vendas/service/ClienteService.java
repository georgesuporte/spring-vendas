package com.vendas.service;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.ClienteEntity;
import com.vendas.repository.ClienteRespository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class ClienteService {
    private final ClienteRespository ClienteRespository;

    public List<ClienteEntity> findAll() {
        return ClienteRespository.findAll();
    }

    public Optional<ClienteEntity> findById(Long id) {
        return ClienteRespository.findById(id);
    }

    public ClienteEntity save(ClienteEntity stock) {
        return ClienteRespository.save(stock);
    }

    public void deleteById(Long id) {
        ClienteRespository.deleteById(id);
    }
}