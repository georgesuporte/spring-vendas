package com.vendas.controller;

import java.util.List;

import com.vendas.model.dto.cliente.ClienteCreationDTO;
import com.vendas.model.dto.cliente.ClienteResponseDTO;
import com.vendas.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.findAll());
    }

    // @GetMapping("/consultar")
    // public ResponseEntity<ClienteCreationDTO> consultar(@RequestBody ClienteCreationDTO clienteCreationDTO) {
    //     Optional<ClienteEntity> result = clienteService
    //             .findById(clienteMapper.toClienteEntity(clienteCreationDTO).getIdCliente());
    //     if (result.get() != null) {
    //         return ResponseEntity.status(HttpStatus.OK).body(clienteMapper.toClienteCreationDTO(result.get()));
    //     } else {
    //         return ResponseEntity.status(HttpStatus.CREATED).build();
    //     }
    // }

    // @PostMapping("/pesquisar")
    // public ResponseEntity<List<ClienteCreationDTO>> search(@RequestBody ClienteCreationDTO clienteCreationDTO) {
    //     return ResponseEntity.status(HttpStatus.CREATED).body(clienteMapper.toListClienteCreationDTOs(clienteService
    //             .findByNomeContainingOrEmailContaining(clienteCreationDTO.getNome(), clienteCreationDTO.getEmail())));
    // }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ClienteResponseDTO> cadastrar(@RequestBody ClienteCreationDTO clienteCreationDTO) {
        clienteCreationDTO.setSenha(passwordEncoder.encode(clienteCreationDTO.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteCreationDTO));
    }

    // @PutMapping("/atualizar")
    // public ResponseEntity<ClienteUpdateDTO> update(@RequestBody ClienteUpdateDTO clienteUpdateDTO) {
    //     return ResponseEntity.status(HttpStatus.OK).body(clienteMapper.toClienteUpdateDTO(
    //             clienteService.save(clienteMapper.toUpdateClienteEntity(clienteUpdateDTO))));
    // }

    // @DeleteMapping("/deletar")
    // public ResponseEntity<HttpStatus> delete(@RequestBody ClienteCreationDTO clienteCreationDTO) {
    //     ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteCreationDTO);
    //     clienteService.deleteById(clienteEntity.getIdCliente());
    //     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    // }


}