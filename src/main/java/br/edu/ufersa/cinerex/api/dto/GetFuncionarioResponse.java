package br.edu.ufersa.cinerex.api.dto;

import java.util.Objects;

import br.edu.ufersa.cinerex.domain.entity.Funcionario;

public record GetFuncionarioResponse(Long id, String nome)
{
    public GetFuncionarioResponse {
        Objects.requireNonNull(id, "ID nao pode ser null");
        Objects.requireNonNull(nome, "Nome nao pode ser null");
    }

    public static GetFuncionarioResponse fromEntity(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Funcionario nao pode ser null");
        return new GetFuncionarioResponse(funcionario.getId(), funcionario.getNome());
    }
}
