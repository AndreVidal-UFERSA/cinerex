package br.edu.ufersa.cinerex.features.filme;

import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;
import br.edu.ufersa.cinerex.features.filme.dto.RequestPostFilme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface FilmeMapper {
    Filme toEntity(RequestPostFilme requestPostFilme);
    FilmeResponse toResponse(Filme filme);
}