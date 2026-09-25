package br.edu.ufersa.cinerex.shared.exceptions;

public class SessaoInexistente extends RuntimeException {
    public SessaoInexistente(String message) {
        super(message);
    }
}
