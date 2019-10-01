package com.vendas.implement.cliente;

import java.util.List;

import com.vendas.entity.ClienteEntity;
import com.vendas.implement.IEntityMapper;
import com.vendas.implement.endereco.EnderecoMapper;
import com.vendas.model.dto.cliente.ClienteCreationDTO;
import com.vendas.model.dto.cliente.ClienteResponseDTO;
import com.vendas.model.dto.cliente.ClienteUpdateDTO;
import com.vendas.model.dto.cliente.ClienteUpdatePasswordDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
@Component
@Mapper(componentModel="spring", uses = {EnderecoMapper.class})
public interface ClienteMapper extends IEntityMapper<ClienteCreationDTO, ClienteEntity>{

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mappings({
        @Mapping(source = "clienteEntity.idEndereco", target = "endereco")
    })
    ClienteCreationDTO toDto(final ClienteEntity clienteEntity);

    ClienteEntity toEntity(final ClienteCreationDTO clienteCreationDTO);

    ClienteUpdateDTO toClienteUpdateDTO(ClienteEntity clienteEntity);

    ClienteEntity toUpdateClienteEntity(ClienteUpdateDTO clienteUpdateDTO);

    ClienteEntity toUpdatePasswordClienteEntity(ClienteUpdatePasswordDTO clienteUpdatePasswordDTO);

    @Mappings({
        @Mapping(source = "clienteEntity.idEndereco", target = "endereco")
    })
    ClienteResponseDTO toClienteResponseDTO(ClienteEntity clienteEntity);

 
    List<ClienteResponseDTO> toListClienteResponseDTOs(List<ClienteEntity> listClienteEntity);


    default ClienteEntity fromId(final Long idCliente) {

        if (idCliente == null) {
            return null;
        }

        final ClienteEntity clienteEntity= new ClienteEntity();

        clienteEntity.setIdCliente(idCliente);

        return clienteEntity;
    }

}
