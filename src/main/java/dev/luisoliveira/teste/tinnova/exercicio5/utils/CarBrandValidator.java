package dev.luisoliveira.teste.tinnova.exercicio5.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarBrandValidator implements ConstraintValidator<CarBrandValidation, String> {
    @Override
    public boolean isValid(String brand, ConstraintValidatorContext constraintValidatorContext) {

        List<String> list = Stream.of(CarBrands.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        return list.contains(brand);
    }
}
