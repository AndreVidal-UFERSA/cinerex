package br.edu.ufersa.cinerex.features.funcionario;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface FuncionarioApplicationMapper {
    Funcionario toEntity(CriarFuncionarioCommand criarFuncionarioCommand);
    FuncionarioResponse toResponse(Funcionario funcionario);
}
