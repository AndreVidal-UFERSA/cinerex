package br.edu.ufersa.cinerex.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (MethodArgumentNotValidException.class)
        public ProblemDetail tratarValidacao(MethodArgumentNotValidException ex){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Um ou mais campos estão inválidos. Corrija e tente novamente.");
        problem.setType(URI.create("about:blank"));
        problem.setTitle("Erro de validação nos dados de entrada");
        problem.setProperty("timestamp", Instant.now());
        Map<String, String> camposComErro = new HashMap<>();
        for (FieldError fe : ex.getBindingResult().getFieldErrors()){
            camposComErro.put(fe.getField(), fe.getDefaultMessage());
        }
        problem.setProperty("erros", camposComErro);
        return problem;
    }

}
