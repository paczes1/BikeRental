import domain.bikes.Bike;
import org.junit.Before;
import org.junit.Test;
import service.BikeService;


public class BikesAssertTest {

    private BikeService bikeService = new BikeService();

    @Before
    public void before() {


    }

    @Test(expected = IllegalArgumentException.class)
    public void bikeAlreadyExists() {
        Bike bike1 = new Bike(1, "Model 1");
        bikeService.create(bike1);
        bikeService.create(bike1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noBikeInMapException() {
        bikeService.read(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noBikeToUpdate() {
        Bike bike = new Bike(1, "Model 1");
        bikeService.update(bike);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteBike() {
        Bike bike = new Bike(1, "Model 1");
        bikeService.delete(bike);
        bikeService.read(bike.getId());
    }


}
