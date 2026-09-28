package br.edu.ufersa.cinerex.features.auth;

import br.edu.ufersa.cinerex.features.auth.dto.FuncionarioResponse;
import br.edu.ufersa.cinerex.features.auth.dto.RequestPostFuncionario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface FuncionarioMapper {
    Funcionario toEntity(RequestPostFuncionario requestPostFuncionario);
    FuncionarioResponse toResponse(Funcionario funcionario);
}
