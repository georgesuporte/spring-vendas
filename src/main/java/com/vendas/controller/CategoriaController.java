package com.vendas.controller;

import java.util.Collection;
import java.util.List;

import com.vendas.entity.CategoriaEntity;
import com.vendas.implement.categoria.CategoriaMapperImpl;
import com.vendas.model.dto.categoria.CategoriaCreationDTO;
import com.vendas.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private CategoriaMapperImpl categoriaMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaCreationDTO>> listar(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriaMapper.toListCategoriaCreationDTOs(categoriaService.findAll()));
    }

    // @GetMapping("/categoria/{id}")
    // public CategoriaEntity show(@PathVariable String id){
    //     int categoriaId = Integer.parseInt(id);
    //     return categoriaService.findOne(categoriaId);
    // }

    // @PostMapping("/categoria/search")
    // public List<CategoriaEntity> search(@RequestBody Map<String, String> body){
    //     String searchTerm = body.get("text");
    //     return categoriaService.findByCategoriaContainingOrContentContaining(searchTerm, searchTerm);
    // }

    @PostMapping(value="/cadastrar")
    public ResponseEntity<CategoriaCreationDTO> cadastrar(@RequestBody CategoriaCreationDTO categoriaCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toCategoriaCreationDTO(categoriaService.save(categoriaMapper.toCategoriaEntity(categoriaCreationDTO))));
    }


    // @PutMapping("/categoria/{id}")
    // public CategoriaEntity update(@PathVariable String id, @RequestBody Map<String, String> body) {
    //     int idCategoria = Integer.parseInt(id);
    //     // getting blog
    //     CategoriaEntity categoria = categoriaService.findOne(idCategoria);
    //     categoria.setCategoria(body.get("categoria"));
    //     return categoriaService.save(categoria);
    // }

    // @DeleteMapping("/categoria/{id}")
    // public boolean delete(@PathVariable String id){
    //     int categoria = Integer.parseInt(id);
    //     categoriaService.deleteById(categoria);
    //     return true;
    // }


}