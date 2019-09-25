package com.vendas.implement.categoria;

import java.util.List;

import com.vendas.entity.CategoriaEntity;
import com.vendas.model.dto.categoria.CategoriaCreationDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    
    @Mappings({
        @Mapping(target="id", source="categoriaEntity.idCategoria"),
        @Mapping(target="nomeCategoria", source="categoriaEntity.categoria") 
    })
    CategoriaCreationDTO toCategoriaCreationDTO(CategoriaEntity categoriaEntity);

    @Mappings({
        @Mapping(source="categoriaCreationDTO.id", target="idCategoria"),
        @Mapping(source="categoriaCreationDTO.nomeCategoria", target="categoria")
    })
    CategoriaEntity toCategoriaEntity(CategoriaCreationDTO categoriaCreationDTO);

    List<CategoriaCreationDTO> toListCategoriaCreationDTOs(List<CategoriaEntity> listCategoriaEntity);

}
