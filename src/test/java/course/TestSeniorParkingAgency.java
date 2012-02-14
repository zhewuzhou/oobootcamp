package course;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestSeniorParkingAgency {
    @Test
    public void test_should_park_car_to_more_idle_space_parkinglot() {
        ParkingFacilitator parkingFacilitatorB = new ParkingLot(4);
        List<ParkingFacilitator> parkingFacilitatorList = new ArrayList<ParkingFacilitator>();
        parkingFacilitatorList.add(new ParkingLot(3));
        parkingFacilitatorList.add(parkingFacilitatorB);
        Car car = new Car();
        ParkingAgency parkingAgency = new ParkingAgency(parkingFacilitatorList, new SeniorChooser());

        parkingAgency.park(car);
        assertThat(parkingFacilitatorB.idleSpace(), is(3));
    }
}
