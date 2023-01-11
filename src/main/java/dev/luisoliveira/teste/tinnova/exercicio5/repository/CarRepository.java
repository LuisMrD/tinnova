package dev.luisoliveira.teste.tinnova.exercicio5.repository;

import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByYearLessThanEqualAndYearGreaterThanEqual(int endDate, int startDate);

    List<CarEntity> findAllByCreatedAtLessThanEqualAndCreatedAtGreaterThanEqual(LocalDateTime endDate, LocalDateTime startDate);

    List<CarEntity> findAllBySoldFalse();

    List<CarEntity> findAllByBrand(String carBrand);
}
