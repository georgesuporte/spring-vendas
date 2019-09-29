package com.vendas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.RollbackException;

import com.vendas.entity.ClienteEntity;
import com.vendas.entity.EnderecoEntity;
import com.vendas.implement.cliente.ClienteMapper;
import com.vendas.implement.endereco.EnderecoMapper;
import com.vendas.model.dto.cliente.ClienteCreationDTO;
import com.vendas.model.dto.cliente.ClienteResponseDTO;
import com.vendas.repository.ClienteRespository;
import com.vendas.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteService {
    @Autowired
    private final ClienteRespository clienteRespository;

    @Autowired
    private final EnderecoService enderecoService;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public List<ClienteEntity> findAll() {
        return clienteRespository.findAll();
    }

    public Optional<ClienteEntity> findById(Long id) {
        return clienteRespository.findById(id);
    }
    
    @Transactional(rollbackFor={Exception.class}, readOnly = false, propagation = Propagation.REQUIRED)
    public ClienteResponseDTO save(ClienteCreationDTO clienteCreationDTO) {
        try {
            ClienteEntity clienteEntity = clienteMapper.toEntity(clienteCreationDTO);
            ClienteEntity createdClienteEntity  = clienteRespository.save(clienteEntity);
            if(clienteCreationDTO.getEndereco().size() > 0){
                clienteCreationDTO.getEndereco().forEach(EnderecoCreationDTO -> {
                    EnderecoCreationDTO.setIdCliente(createdClienteEntity);
                });
                List<EnderecoEntity> enderecoCreate = enderecoService.saveAll(enderecoMapper.toEntity(clienteCreationDTO.getEndereco()));
                ClienteResponseDTO dto = clienteMapper.toClienteResponseDTO(createdClienteEntity);
                dto.setEndereco(enderecoMapper.toListEnderecoResponseDTO(enderecoMapper.toDto(enderecoCreate)));
                return dto;
            } else {
                return clienteMapper.toClienteResponseDTO(clienteEntity);
            }
            
         } catch (Exception e) {
            throw new RollbackException("Erro ao cadastrar cliente. Exception:[" + e.getMessage() + "]"); 
		}
    }

    public void deleteById(Long id) {
        clienteRespository.deleteById(id);
    }

	public List<ClienteEntity> findByNomeContainingOrEmailContaining(String nomeCliente,String emailCliente ) {
		return clienteRespository.findByNomeContainingOrEmailContaining(nomeCliente, emailCliente);
	}
}