package com.vendas.controller;

import com.vendas.implement.endereco.EnderecoMapper;
import com.vendas.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    // @GetMapping("/listar")
    // public ResponseEntity<List<EnderecoCreationDTO>> listar() {
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(enderecoMapper.toListEnderecoDtos(enderecoService.findAll()));
    // }

    // @GetMapping("/consultar")
    // public ResponseEntity<EnderecoCreationDTO> consultar(@RequestBody EnderecoCreationDTO EnderecoCreationDTO) {
    //     Optional<EnderecoEntity> result = enderecoService
    //             .findById(enderecoMapper.toEnderecoEntity(EnderecoCreationDTO).getIdEndereco());
    //     if (result.get() != null) {
    //         return ResponseEntity.status(HttpStatus.OK).body(enderecoMapper.toEnderecoCreationDTO(result.get()));
    //     } else {
    //         return ResponseEntity.status(HttpStatus.CREATED).build();
    //     }
    // }

    // @PostMapping("/pesquisar")
    // public ResponseEntity<List<EnderecoCreationDTO>> search(@RequestBody EnderecoCreationDTO EnderecoCreationDTO) {
    //     return ResponseEntity.status(HttpStatus.CREATED).body(enderecoMapper.toListEnderecoDtos(enderecoService
    //             .findByRuaContainingOrBairroContaining(EnderecoCreationDTO.getRua(), EnderecoCreationDTO.getBairro())));
    // }

    // @PostMapping(value = "/cadastrar")
    // public ResponseEntity<EnderecoCreationDTO> cadastrar(@RequestBody EnderecoCreationDTO EnderecoCreationDTO) {
    //     return ResponseEntity.status(HttpStatus.CREATED).body(enderecoMapper.toEnderecoCreationDTO(
    //             enderecoService.save(enderecoMapper.toEnderecoEntity(EnderecoCreationDTO))));
    // }

    // @PutMapping("/atualizar")
    // public ResponseEntity<EnderecoCreationDTO> update(@RequestBody EnderecoCreationDTO enderecoCreationDTO) {
    //     return ResponseEntity.status(HttpStatus.OK).body(enderecoMapper.toEnderecoCreationDTO(
    //             enderecoService.save(enderecoMapper.toEnderecoEntity(enderecoCreationDTO))));
    // }

    // @DeleteMapping("/deletar")
    // public ResponseEntity<HttpStatus> delete(@RequestBody EnderecoCreationDTO EnderecoCreationDTO) {
    //     EnderecoEntity enderecoEntity = enderecoMapper.toEnderecoEntity(EnderecoCreationDTO);
    //     enderecoService.deleteById(enderecoEntity.getIdEndereco());
    //     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    // }

}