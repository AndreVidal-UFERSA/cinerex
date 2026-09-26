package br.edu.ufersa.cinerex.features.sala;

import br.edu.ufersa.cinerex.features.sala.dto.RequestPostSala;
import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaMapper {
    Sala toEntity(RequestPostSala requestPostSala);
    SalaResponse toResponse(Sala sala);
}
