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
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaCreationDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaMapper.toListCategoriaCreationDTOs(categoriaService.findAll()));
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<CategoriaCreationDTO> consultar(@RequestBody CategoriaCreationDTO categoriaID) {
        Optional<CategoriaEntity> result = categoriaService
                .findById(categoriaMapper.toCategoriaEntity(categoriaID).getIdCategoria());
        if(result.get() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaMapper.toCategoriaCreationDTO(result.get()));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
    }

    // @PostMapping("/categoria/search")
    // public List<CategoriaEntity> search(@RequestBody Map<String, String> body){
    //     String searchTerm = body.get("text");
    //     return categoriaService.findByCategoriaContainingOrContentContaining(searchTerm, searchTerm);
    // }

    @PostMapping(value="/cadastrar")
    public ResponseEntity<CategoriaCreationDTO> cadastrar(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toCategoriaCreationDTO(categoriaService.save(categoriaMapper.toCategoriaEntity(categoriaCreationDTO))));
    }


    // @PutMapping("/atualizar/{id}")
    // public CategoriaEntity update(@PathVariable String id, @RequestBody Map<String, String> body) {
    //     int idCategoria = Integer.parseInt(id);
    //     // getting blog
    //     CategoriaEntity categoria = categoriaService.findOne(idCategoria);
    //     categoria.setCategoria(body.get("categoria"));
    //     return categoriaService.save(categoria);
    // }

    // @DeleteMapping("/deletar/{id}")
    // public boolean delete(@PathVariable String id){
    //     int categoria = Integer.parseInt(id);
    //     categoriaService.deleteById(categoria);
    //     return true;
    // }


}