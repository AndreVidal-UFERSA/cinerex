package br.edu.ufersa.cinerex.features.sessao;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface SessaoMapper {
    SessaoDTO toDTO(Sessao entity);
}
