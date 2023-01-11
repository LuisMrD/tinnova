package dev.luisoliveira.teste.tinnova.car.repository;

import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import dev.luisoliveira.teste.tinnova.exercicio5.repository.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("application-test")
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @DisplayName("Junit test for update a car")
    @Test
    public void givenANewCar_whenUpdateAllFieldsOfThatCar_thenAssertTrue(){
        CarEntity car = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1980)
                .description("Carro veloz")
                .sold(false)
                .build();

        carRepository.save(car);

        Optional<CarEntity> carSaved = carRepository.findById(1L);

        carSaved.get().setName("nome update");
        carSaved.get().setBrand("TOYOTA");
        carSaved.get().setProductionYear(2011);
        carSaved.get().setSold(true);

        carRepository.save(carSaved.get());

        Optional<CarEntity> carUpdated = carRepository.findById(1L);

        assertThat(carUpdated.get().getName()).isEqualTo("nome update");
        assertThat(carUpdated.get().getBrand()).isEqualTo("TOYOTA");
        assertThat(carUpdated.get().getProductionYear()).isEqualTo(2011);
        assertThat(carUpdated.get().getSold()).isEqualTo(true);
    }

    @DisplayName("Junit test for save operation")
    @Test
    public void givenNewCarEntity_whenCreateNewCar_thenAssertTrue(){
        CarEntity car = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1988)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity savedCar = carRepository.save(car);

        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get by year of production")
    @Test
    public void givenThreeCarsOfSameYear_whenFindByThatYear_thenAssertTrue(){
        CarEntity car1 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1980)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car2 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1985)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car3 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1989)
                .description("Carro veloz")
                .sold(false)
                .build();

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        List<CarEntity> cars = carRepository.findAllByProductionYearLessThanEqualAndProductionYearGreaterThanEqual(1989,1980);


        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("Junit test for get by brand")
    @Test
    public void givenThreeCarsOfSameBrand_whenFindByThatBrand_thenAssertTrue(){
        CarEntity car1 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1980)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car2 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1985)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car3 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1989)
                .description("Carro veloz")
                .sold(false)
                .build();

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        List<CarEntity> cars = carRepository.findAllByBrand("FORD");

        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("Junit test for get by not sold")
    @Test
    public void givenThreeNotSold_whenFindByNotSoldCars_thenAssertTrue(){
        CarEntity car1 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1980)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car2 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1985)
                .description("Carro veloz")
                .sold(false)
                .build();

        CarEntity car3 = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1989)
                .description("Carro veloz")
                .sold(false)
                .build();

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        List<CarEntity> cars = carRepository.findAllBySoldFalse();

        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("Junit test for delete a car")
    @Test
    public void givenANewCar_whenDeleteThatCar_thenAssertTrue(){
        CarEntity car = CarEntity.builder()
                .name("carro")
                .brand("FORD")
                .productionYear(1980)
                .description("Carro veloz")
                .sold(false)
                .build();

        carRepository.save(car);

        Optional<CarEntity> carSaved = carRepository.findById(1L);

        carSaved.ifPresent(carEntity -> carRepository.delete(carEntity));

        List<CarEntity> cars = carRepository.findAll();

        assertThat(cars.size()).isNotEqualTo(1);
    }

}
