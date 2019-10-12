package repositories;

import domain.bikes.Bike;

import java.util.List;

public interface BikeRepository {

    void create(Bike bike);
    List<Bike> readAll();
    Bike read(Bike bikeId);
    void update(Bike bike);
    void delete(Bike bikeId);

}
