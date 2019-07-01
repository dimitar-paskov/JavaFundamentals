package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class SoftParkTest {

    private SoftPark softPark;
    Car car;


    @Before
    public void test(){
        this.softPark = new SoftPark();
        this.car = new Car("BMW", "1234");

    }


    @Test
    public void emptyParking(){
        Map<String, Car> received = this.softPark.getParking();
        Assert.assertEquals(12, received.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void parkingSpotDoesntExists(){
        this.softPark.parkCar("F1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkingSpotAlreadyTaken(){
        this.softPark.parkCar("A1", car);
        Car newCar = new Car("MMM", "1235");
        this.softPark.parkCar("A1", newCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkingOnOtherSpot(){
        this.softPark.parkCar("A1", car);
        Car newCar = new Car("MMM", "1235");
        String result = this.softPark.parkCar("B2", newCar);
//       Assert.assertEquals("Car:1235 parked successfully!", result);
    }

    @Test(expected = IllegalStateException.class)
    public void parkTwiceOneCar(){
        this.softPark.parkCar("A1", car);
        this.softPark.parkCar("A2", car);
    }

    @Test
    public void parkShouldWork(){
        String result = this.softPark.parkCar("A1", car);
        Assert.assertEquals("Car:1234 parked successfully!", result);

    }

    @Test
    public void parkShouldWorkAndCarIsParked(){
        this.softPark.parkCar("A1", car);
        Assert.assertEquals(car, this.softPark.getParking().get("A1"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFromNonExistentSpot(){
        this.softPark.removeCar("F1", car);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFromNull(){
        this.softPark.removeCar("A1", car);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarNotFoundOnSpot(){
        this.softPark.parkCar("A1", car);
        Car newcar = new Car("MMM", "1543");
        this.softPark.removeCar("A1", newcar);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarFromOtherSpot(){
        this.softPark.parkCar("A1", car);
        this.softPark.removeCar("A2", car);

    }

    @Test
    public void removeShouldWork(){
        this.softPark.parkCar("A1", car);
        String result = this.softPark.removeCar("A1", car);
        Assert.assertEquals("Remove car:1234 successfully!", result);

    }

    @Test
    public void removeShouldLeaveSpotNull(){
        this.softPark.parkCar("A1", car);
        String result = this.softPark.removeCar("A1", car);

        Map<String, Car> received = this.softPark.getParking();

        Assert.assertEquals(null, received.get("A1"));

    }

}