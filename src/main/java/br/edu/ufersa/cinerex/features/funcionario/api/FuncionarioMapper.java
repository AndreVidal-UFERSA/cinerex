package br.edu.ufersa.cinerex.features.funcionario.api;

import br.edu.ufersa.cinerex.features.funcionario.application.CriarFuncionarioCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {
    CriarFuncionarioCommand toCommand(FuncionarioPostRequest funcionarioPostRequest);
}
