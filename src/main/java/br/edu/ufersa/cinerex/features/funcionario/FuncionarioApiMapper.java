package br.edu.ufersa.cinerex.features.funcionario;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface FuncionarioApiMapper {
    CriarFuncionarioCommand toCommand(FuncionarioPostRequest funcionarioPostRequest);
}
