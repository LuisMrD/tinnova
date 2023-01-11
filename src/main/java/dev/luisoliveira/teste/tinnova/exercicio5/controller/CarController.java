package dev.luisoliveira.teste.tinnova.exercicio5.controller;

import dev.luisoliveira.teste.tinnova.exercicio5.dto.CarDto;
import dev.luisoliveira.teste.tinnova.exercicio5.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCar(@Valid @RequestBody CarDto carDto) {
        carService.createCar(carDto);
    }

    @PutMapping
    @RequestMapping("atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCarAllFields(@PathVariable("id") long id, @RequestBody CarDto carDto){
        carService.updateCarAllFields(id, carDto);
    }

    @PatchMapping
    @RequestMapping("/atualizar/parcial/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCarSomeFields(@PathVariable("id") long id, @RequestBody CarDto carDto){
        carService.updateCarSomeFields(id, carDto);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable("id") long id){
        carService.removeById(id);
    }

    @GetMapping
    @RequestMapping("/ano/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAllCarsByDecade(@PathVariable("year") int year){
        return carService.findAllByDecade(year);
    }

    @GetMapping
    @RequestMapping("/marca/{carBrand}")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAllCarsByBrand(@PathVariable("carBrand") String carBrand){
        return carService.findAllCarsByBrand(carBrand);
    }

    @GetMapping
    @RequestMapping("/naovendidos")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAllCarsNotSold() {
        return carService.findAllCarsNotSold();
    }

    @GetMapping
    @RequestMapping("/ultimasemana")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getAllCarsCreatedOnLastWeek() {
        return carService.findAllByCreatedAtLastWeek();
    }
}
