package repositories;

import domain.bikes.Bike;

import java.util.Map;

public interface BikeRepository {

    void create(Bike bike);

    Map<Integer, Bike> readAll();

    Bike read(Integer bikeId);

    void update(Bike bike);

    void delete(Bike bike);

}
