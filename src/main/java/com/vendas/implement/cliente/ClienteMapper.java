package com.vendas.implement.cliente;

import java.util.List;

import com.vendas.entity.ClienteEntity;
import com.vendas.model.dto.cliente.ClienteCreationDTO;
import com.vendas.model.dto.cliente.ClienteUpdateDTO;
import com.vendas.model.dto.cliente.ClienteUpdatePasswordDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
 
    @Mappings({
        @Mapping(target="id", source="clienteEntity.idCliente"),
    })
    ClienteCreationDTO toClienteCreationDTO(ClienteEntity clienteEntity);

    @Mappings({
        @Mapping(target="id", source="clienteEntity.idCliente"),
    })
    ClienteUpdateDTO toClienteUpdateDTO(ClienteEntity clienteEntity);

    @Mappings({
        @Mapping(target="idCliente", source="clienteUpdateDTO.id"),
    })
    ClienteEntity toUpdateClienteEntity(ClienteUpdateDTO clienteUpdateDTO);

    @Mappings({
        @Mapping(target="idCliente", source="clienteUpdatePasswordDTO.id"),
    })
    ClienteEntity toUpdatePasswordClienteEntity(ClienteUpdatePasswordDTO clienteUpdatePasswordDTO);

    @Mappings({
        @Mapping(target="idCliente", source="clienteCreationDTO.id"),
    })
    ClienteEntity toClienteEntity(ClienteCreationDTO clienteCreationDTO);

    List<ClienteCreationDTO> toListClienteCreationDTOs(List<ClienteEntity> listClienteEntity);

}
