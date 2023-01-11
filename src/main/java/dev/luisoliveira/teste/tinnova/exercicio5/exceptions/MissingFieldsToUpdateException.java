package dev.luisoliveira.teste.tinnova.exercicio5.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus( value = HttpStatus.BAD_REQUEST)
public class MissingFieldsToUpdateException extends RuntimeException {

    public MissingFieldsToUpdateException() {
        super("É preciso forncecer todos os campos para atualizar este registro");
    }
}
