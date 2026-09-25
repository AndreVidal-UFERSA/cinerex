package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngressoMapper {
    Ingresso toEntity(IngressoCreate ingressoCreate);
    IngressoResponse toResponse(Ingresso ingresso);
}
