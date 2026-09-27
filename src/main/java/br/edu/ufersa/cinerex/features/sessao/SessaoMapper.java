package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.sessao.dto.RequestPostSessao;
import br.edu.ufersa.cinerex.features.sessao.dto.SessaoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface SessaoMapper {
    SessaoResponse toDTO(Sessao entity);
    Sessao toEntity(RequestPostSessao requestPostSessao);
}
