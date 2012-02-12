package course;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestSuperParkingAgency {
    @Test
    public void test_should_park_car_to_bigger_volum_percentage(){
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        ParkingLot parkingLotLow = new ParkingLot(10);
        Car first = new Car();
        parkingLotLow.park(first);
        ParkingLot parkingLotHigh = new ParkingLot(2);

        parkingLots.add(parkingLotLow);
        parkingLots.add(parkingLotHigh);

        SuperParkingAgency superParkingAgency = new SuperParkingAgency(parkingLots);

        Car second = new Car();
        superParkingAgency.park(second);

        assertThat(parkingLotHigh.idleSpace(), is(1));
    }
}
