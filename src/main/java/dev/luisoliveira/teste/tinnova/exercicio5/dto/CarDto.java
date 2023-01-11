package dev.luisoliveira.teste.tinnova.exercicio5.dto;

import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import dev.luisoliveira.teste.tinnova.exercicio5.utils.CarBrandValidation;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarDto {

    private long id;

    private String name;

    @CarBrandValidation
    private String brand;

    private int year;

    private String description;

    private Boolean sold;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static CarDto of(CarEntity carEntity){
        CarDto carDto = new CarDto();
        carDto.setId(carEntity.getId());
        carDto.setName(carEntity.getName());
        carDto.setBrand(carEntity.getBrand());
        carDto.setYear(carEntity.getProductionYear());
        carDto.setDescription(carEntity.getDescription());
        carDto.setSold(carEntity.getSold());
        carDto.setCreatedAt(carEntity.getCreatedAt());
        carDto.setUpdatedAt(carEntity.getUpdatedAt());

        return carDto;
    }

}
