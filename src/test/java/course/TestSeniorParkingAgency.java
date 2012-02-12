package course;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestSeniorParkingAgency {
    @Test
    public void test_should_park_car_to_more_idle_space_parkinglot() {
        ParkingLot parkingLotB = new ParkingLot(4);
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(parkingLotB);
        Car car = new Car();
        SeniorParkingAgency seniorParkingAgency = new SeniorParkingAgency(parkingLotList);

        seniorParkingAgency.park(car);
        assertThat(parkingLotB.idleSpace(), is(3));
    }
}
