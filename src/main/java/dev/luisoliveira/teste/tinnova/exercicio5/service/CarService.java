package dev.luisoliveira.teste.tinnova.exercicio5.service;

import dev.luisoliveira.teste.tinnova.exercicio5.dto.CarDto;
import dev.luisoliveira.teste.tinnova.exercicio5.entity.CarEntity;
import dev.luisoliveira.teste.tinnova.exercicio5.exceptions.MissingFieldsToUpdateException;
import dev.luisoliveira.teste.tinnova.exercicio5.exceptions.ResourceNotFoundException;
import dev.luisoliveira.teste.tinnova.exercicio5.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(CarDto carDto) {
        CarEntity car = new CarEntity();
        car.setName(carDto.getName());
        car.setBrand(carDto.getBrand());
        car.setYear(carDto.getYear());
        car.setDescription(carDto.getDescription());
        car.setSold(carDto.getSold());

        carRepository.save(car);
    }

    public void updateCarAllFields(long id, CarDto carDto){
        Optional<CarEntity> car = carRepository.findById(id);

        verifyIfSomeFieldIsNull(id, carDto, car);

        car.get().setName(carDto.getName());
        car.get().setBrand(carDto.getBrand());
        car.get().setYear(carDto.getYear());
        car.get().setDescription(carDto.getDescription());
        car.get().setSold(carDto.getSold());

        carRepository.save(car.get());
    }

    private void verifyIfSomeFieldIsNull(long id, CarDto carDto, Optional<CarEntity> car) {
        if(car.isEmpty()) throw new ResourceNotFoundException("Car", "id", id);
        if(carDto.getName() == null) throw new MissingFieldsToUpdateException();
        if(carDto.getBrand() == null) throw new MissingFieldsToUpdateException();
        if(carDto.getYear() == 0) throw new MissingFieldsToUpdateException();
        if(carDto.getDescription() == null) throw new MissingFieldsToUpdateException();
        if(carDto.getSold() == null) throw new MissingFieldsToUpdateException();
    }

    public void updateCarSomeFields(long id, CarDto carDto){
        Optional<CarEntity> car = carRepository.findById(id);

        if(car.isEmpty()) throw new ResourceNotFoundException("Car", "id", id);

        if(carDto.getName() != null) car.get().setName(carDto.getName());
        if(carDto.getBrand() != null)car.get().setBrand(carDto.getBrand());
        if(carDto.getYear() != 0)car.get().setYear(carDto.getYear());
        if(carDto.getDescription() != null)car.get().setDescription(carDto.getDescription());
        if(carDto.getSold() != null)car.get().setSold(carDto.getSold());

        carRepository.save(car.get());
    }

    public void removeById(long id){
        Optional<CarEntity> car = carRepository.findById(id);

        if(car.isEmpty()) throw new ResourceNotFoundException("Car", "id", id);

        carRepository.delete(car.get());
    }

    public List<CarDto> findAllByDecade(int year){
        int startYear = getStarDate(year);
        int endYear = getEndDate(year);

        List<CarEntity> cars = carRepository.findAllByYearLessThanEqualAndYearGreaterThanEqual(endYear, startYear);

        return cars.stream().map(CarDto::of).collect(Collectors.toList());
    }

    private int getStarDate(int year){
        String firstThreeDigitsToConstructANewDate = String.valueOf(year).substring(0,3);
        return Integer.parseInt(firstThreeDigitsToConstructANewDate + "0");
    }

    private int getEndDate(int year){
        String firstThreeDigitsToConstructANewDate = String.valueOf(year).substring(0,3);
        return Integer.parseInt(firstThreeDigitsToConstructANewDate + "9");
    }

    public List<CarDto> findAllCarsNotSold(){
        return carRepository.findAllBySoldFalse().stream().map(CarDto::of).collect(Collectors.toList());
    }

    public List<CarDto> findAllCarsByBrand(String carBrand){
        return carRepository.findAllByBrand(carBrand.toUpperCase()).stream().map(CarDto::of).collect(Collectors.toList());
    }

    public List<CarDto> findAllByCreatedAtLastWeek(){
        final ZonedDateTime startOfLastWeek = getStartOfLastWeek();
        final ZonedDateTime endOfLastWeek = getEndOfLastWeek(startOfLastWeek);

        return carRepository.findAllByCreatedAtLessThanEqualAndCreatedAtGreaterThanEqual(
                endOfLastWeek.toLocalDateTime(), startOfLastWeek.toLocalDateTime())
                .stream().map(CarDto::of).collect(Collectors.toList());
    }

    private ZonedDateTime getStartOfLastWeek() {
        final ZonedDateTime input = ZonedDateTime.now();
        final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
        return startOfLastWeek;
    }

    private ZonedDateTime getEndOfLastWeek(ZonedDateTime startOfLastWeek) {
        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
        return endOfLastWeek;
    }

}
