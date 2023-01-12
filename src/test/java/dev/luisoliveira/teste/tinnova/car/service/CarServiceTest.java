package dev.luisoliveira.teste.tinnova.car.service;

import dev.luisoliveira.teste.tinnova.exercicio5.dto.CarDto;
import dev.luisoliveira.teste.tinnova.exercicio5.repository.CarRepository;
import dev.luisoliveira.teste.tinnova.exercicio5.service.CarService;
import org.hibernate.query.sqm.mutation.internal.cte.CteInsertStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class CarServiceTest {

    private CarService carservice;
    private CarRepository carRepository;

    @BeforeEach
    public void setup(){
        carRepository = Mockito.mock(CarRepository.class);
        carservice = new CarService(carRepository);
    }



}
