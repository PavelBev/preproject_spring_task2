package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService extends Car {
    private List<Car> cars = Arrays.asList(
        new Car("Audi", "Red", 2023),
        new Car("BMW", "Blue", 2024),
        new Car("Honda", "Yellow", 2001),
        new Car("Mercedes", "Green", 2024),
        new Car("Volvo", "Yellow", 1990)
    );

    public List<Car> getCars(int count) {
        if (count > cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
