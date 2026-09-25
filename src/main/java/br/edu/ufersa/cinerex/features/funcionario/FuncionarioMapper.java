package br.edu.ufersa.cinerex.features.funcionario;

import br.edu.ufersa.cinerex.features.funcionario.dto.FuncionarioResponse;
import br.edu.ufersa.cinerex.features.funcionario.dto.RequestPostFuncionario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface FuncionarioMapper {
    Funcionario toEntity(RequestPostFuncionario requestPostFuncionario);
    FuncionarioResponse toResponse(Funcionario funcionario);
}
