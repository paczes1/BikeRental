package service;

import domain.bikes.Bike;
import repositories.BikeRepository;

import java.util.HashMap;
import java.util.Map;

public class BikeService implements BikeRepository {

    private Map<Integer, Bike> bikeMap = new HashMap<>();

    @Override
    public void create(Bike bike) {
        for (Integer id : bikeMap.keySet()) {
            if (id == bike.getId()) {
                throw new IllegalArgumentException("Bike already exists");
            }
        }
        bikeMap.put(bike.getId(), bike);

    }

    @Override
    public Map<Integer, Bike> readAll() {
        return bikeMap;
    }

    @Override
    public Bike read(Integer bikeId) {
        Bike readBike = null;
        for (Integer id : bikeMap.keySet()) {
            if (id.equals(bikeId)) {
                readBike = bikeMap.get(id);
            }
        }
        if (readBike != null) {
            return readBike;
        } else {
            throw new IllegalArgumentException("There is no bike");
        }
    }

    @Override
    public void update(Bike bike) {
        Bike readBike = bikeMap.get(bike.getId());
            if(readBike == null) {
                throw new IllegalArgumentException("There is no bike");
            }
                bikeMap.replace(readBike.getId(), bikeMap.get(readBike.getId()), readBike);
            }

    @Override
    public void delete(Bike bike) {
        bikeMap.remove(bike.getId());
    }
}
