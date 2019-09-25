package com.vendas.controller;

import java.util.List;
import java.util.Optional;

import com.vendas.entity.CategoriaEntity;
import com.vendas.implement.categoria.CategoriaMapper;
import com.vendas.model.dto.categoria.CategoriaCreationDTO;
import com.vendas.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaCreationDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaMapper.toListCategoriaCreationDTOs(categoriaService.findAll()));
    }

    @GetMapping("/consultar")
    public ResponseEntity<CategoriaCreationDTO> consultar(@RequestBody CategoriaCreationDTO categoriaID) {
        Optional<CategoriaEntity> result = categoriaService
                .findById(categoriaMapper.toCategoriaEntity(categoriaID).getIdCategoria());
        if (result.get() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaMapper.toCategoriaCreationDTO(result.get()));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PostMapping("/pesquisar")
    public ResponseEntity<List<CategoriaCreationDTO>> search(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toListCategoriaCreationDTOs(
                categoriaService.findByCategoriaContaining(categoriaCreationDTO.getNomeCategoria())));
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<CategoriaCreationDTO> cadastrar(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toCategoriaCreationDTO(
                categoriaService.save(categoriaMapper.toCategoriaEntity(categoriaCreationDTO))));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<CategoriaCreationDTO> update(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaMapper.toCategoriaCreationDTO(
                categoriaService.save(categoriaMapper.toCategoriaEntity(categoriaCreationDTO))));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<HttpStatus> delete(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        CategoriaEntity categoria = categoriaMapper.toCategoriaEntity(categoriaCreationDTO);
        categoriaService.deleteById(categoria.getIdCategoria());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}