package br.edu.ufersa.cinerex.features.ingresso.api;

import br.edu.ufersa.cinerex.features.ingresso.application.CriarIngressoCommand;
import org.mapstruct.Mapper;

import br.edu.ufersa.cinerex.features.ingresso.api.dto.IngressoPostRequest;

@Mapper(componentModel = "spring")
public interface IngressoMapper {
    CriarIngressoCommand toCommand(IngressoPostRequest IngressoPostRequest);
}
