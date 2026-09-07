package br.edu.ufersa.cinerex.domain.exception;

public class FuncionarioNaoExisteException extends RuntimeException {
    public FuncionarioNaoExisteException(String message) {
        super(message);
    }
}
