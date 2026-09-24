package br.edu.ufersa.cinerex.features.funcionario.api;

import br.edu.ufersa.cinerex.features.funcionario.application.CriarFuncionarioCommand;
import org.mapstruct.Mapper;

import br.edu.ufersa.cinerex.features.funcionario.api.dto.FuncionarioPostRequest;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {
    CriarFuncionarioCommand toCommand(FuncionarioPostRequest funcionarioPostRequest);
}
