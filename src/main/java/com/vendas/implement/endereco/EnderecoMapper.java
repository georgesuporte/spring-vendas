package com.vendas.implement.endereco;

import java.util.List;

import com.vendas.entity.EnderecoEntity;
import com.vendas.implement.IEntityMapper;
import com.vendas.implement.cliente.ClienteMapper;
import com.vendas.model.dto.endereco.EnderecoCreationDTO;
import com.vendas.model.dto.endereco.EnderecoResponseDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring", uses = {ClienteMapper.class})
public interface EnderecoMapper extends IEntityMapper<EnderecoCreationDTO, EnderecoEntity>{

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoCreationDTO toDto(final EnderecoEntity enderecoEntity);

    List<EnderecoCreationDTO> toDto(final List<EnderecoEntity> enderecoEntity);

    EnderecoEntity toEntity(final EnderecoCreationDTO enderecoCreationDTO);

    List<EnderecoEntity> toEntity(List<EnderecoCreationDTO> enderecoCreate);
    
    List<EnderecoResponseDTO> toListEnderecoResponseDTO(List<EnderecoCreationDTO> enderecoEntity);

    default EnderecoEntity fromId(final Long idEndereco) {

        if (idEndereco == null) {
            return null;
        }

        final EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setIdEndereco(idEndereco);

        return enderecoEntity;
    }

}
