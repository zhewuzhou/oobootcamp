package course;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestSuperParkingAgency {
    @Test
    public void test_should_park_car_to_bigger_volum_percentage(){
        List<ParkingFacilitator> parkingFacilitators = new ArrayList<ParkingFacilitator>();
        ParkingFacilitator parkingFacilitatorLow = new ParkingLot(10);
        Car first = new Car();
        parkingFacilitatorLow.park(first);
        ParkingFacilitator parkingFacilitatorHigh = new ParkingLot(2);

        parkingFacilitators.add(parkingFacilitatorLow);
        parkingFacilitators.add(parkingFacilitatorHigh);

        ParkingAgency parkingAgency = new ParkingAgency(parkingFacilitators, new SuperChooser());

        Car second = new Car();
        parkingAgency.park(second);

        assertThat(parkingFacilitatorHigh.idleSpace(), is(1));
    }
}
