package br.edu.ufersa.cinerex.features.funcionario.application;

import br.edu.ufersa.cinerex.features.funcionario.domain.Funcionario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {
    Funcionario toEntity(CriarFuncionarioCommand criarFuncionarioCommand);
}
