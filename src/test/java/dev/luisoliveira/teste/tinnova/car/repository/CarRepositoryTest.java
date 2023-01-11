package dev.luisoliveira.teste.tinnova.car.repository;

import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import dev.luisoliveira.teste.tinnova.exercicio5.repository.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @DisplayName("Junit test for save operation")
    @Test
    public void givenRegisteredBrand_whenFindByBrand_thenNotThrowsException(){

        CarEntity car = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .year(1988)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity savedCar = carRepository.save(car);

        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isGreaterThan(0);



    }
}
