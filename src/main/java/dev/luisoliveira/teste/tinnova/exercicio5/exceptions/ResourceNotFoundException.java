package dev.luisoliveira.teste.tinnova.exercicio5.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public
class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;
    private Long longFieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {

        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Long longFieldValue) {

        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, longFieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.longFieldValue = longFieldValue;
    }
}
