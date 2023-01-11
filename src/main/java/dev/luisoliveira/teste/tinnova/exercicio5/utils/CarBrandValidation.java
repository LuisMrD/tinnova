package dev.luisoliveira.teste.tinnova.exercicio5.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CarBrandValidator.class)
public @interface CarBrandValidation {

    public String message() default "Invalid car brand";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
