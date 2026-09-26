package br.edu.ufersa.cinerex.shared.exceptions;

public class RecursoJaExiste extends RuntimeException {
    public RecursoJaExiste(String message) {
        super(message);
    }
}