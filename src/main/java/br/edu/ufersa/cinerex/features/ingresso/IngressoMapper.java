package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface IngressoMapper {
    IngressoResponse toResponse(Ingresso ingresso);
}
