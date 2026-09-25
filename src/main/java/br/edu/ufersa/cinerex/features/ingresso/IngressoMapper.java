package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.CriarIngressoCommand;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngressoMapper {
    CriarIngressoCommand toCommand(IngressoCreate ingressoCreateDTO);
}
