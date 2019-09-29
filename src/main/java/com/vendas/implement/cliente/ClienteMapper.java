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
        @Mapping(source = "clienteEntity.idCliente", target = "id"),
        @Mapping(source = "clienteEntity.idEndereco", target = "endereco")
    })
    ClienteCreationDTO toDto(final ClienteEntity clienteEntity);

    // @Mappings({
    //     @Mapping(source = "clienteCreationDTO.endereco", target = "idEndereco")
    // })
    ClienteEntity toEntity(final ClienteCreationDTO clienteCreationDTO);

    @Mappings({
        @Mapping(target="id", source="clienteEntity.idCliente")
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
        @Mapping(source="clienteEntity.idCliente", target="id"),
    })
    ClienteResponseDTO toClienteResponseDTO(ClienteEntity clienteEntity);

    // @Mappings({
    //     @Mapping(source="clienteEntity.idCliente", target="id"),
    //     @Mapping(source = "clienteEntity.idEndereco", target = "endereco")
    // })
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
