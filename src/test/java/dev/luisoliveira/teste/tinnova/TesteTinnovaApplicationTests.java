package dev.luisoliveira.teste.tinnova;

import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import dev.luisoliveira.teste.tinnova.exercicio5.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class TesteTinnovaApplicationTests {

	@Autowired
	private CarRepository carRepository;

	@Test
	void contextLoads() {

			CarEntity car = CarEntity.builder()
					.name("carro")
					.brand("FORD")
					.productionYear(1991)
					.description("Carro veloz")
					.sold(false)
					.build();

			CarEntity savedCar = carRepository.save(car);

			assertThat(savedCar).isNotNull();
			assertThat(savedCar.getId()).isGreaterThan(0);

	}

}
